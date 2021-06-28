package com.weather.lookup.app.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.lookup.app.domain.WeatherInfo;
import com.weather.lookup.app.service.WeatherLookupService;
import com.weather.lookup.app.utility.RemoteCallHelper;
import com.weather.lookup.app.utility.WeatherTypeEnum;

@Service
public class WeatherLookupServiceImpl implements WeatherLookupService {
	
	@Autowired
	RemoteCallHelper remoteCallHelper;

	@Override
	public WeatherInfo getCurrentWeatherInfo(String cityName) throws Exception {
		
		String response = remoteCallHelper.getWeatherInfo(cityName);
		checkResponseStatus(response);

		System.out.println(response);
		return getWeatherInfo(response);
	}

	@Override
	public List<WeatherInfo> getHistoricalWeatherInfo() {
		return null;
	}
	
	void checkResponseStatus(String response) throws Exception {
		JSONObject obj = new JSONObject(response);
		
		if(obj.getInt("cod") != 200) {
			throw new Exception(obj.getString("message"));
		}
	}
	
	WeatherInfo getWeatherInfo(String response){
		JSONObject obj = new JSONObject(response);
		
		JSONObject object = obj.getJSONObject("main");
		WeatherInfo info = new WeatherInfo();
		info.setTemp(object.getDouble("temp"));
		info.setPressure(object.getInt("pressure"));
		
		JSONArray weather = obj.getJSONArray("weather");
		String get = weather.getJSONObject(0).getString("main");
		
		checkUmbrellaRequired(info, get);
		
		return info;
	}

	private void checkUmbrellaRequired(WeatherInfo info,String value) {
		info.setUmbrella(WeatherTypeEnum.fromValue(value));
	}

}
