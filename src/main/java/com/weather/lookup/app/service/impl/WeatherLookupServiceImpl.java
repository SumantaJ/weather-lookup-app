package com.weather.lookup.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.lookup.app.dao.WeatherLookupRepository;
import com.weather.lookup.app.domain.HistoricalWeatherInfo;
import com.weather.lookup.app.domain.WeatherInfo;
import com.weather.lookup.app.service.WeatherLookupService;
import com.weather.lookup.app.utility.Constants;
import com.weather.lookup.app.utility.JsonParsingUtility;
import com.weather.lookup.app.utility.RemoteCallHelper;

@Service
public class WeatherLookupServiceImpl implements WeatherLookupService {

	@Autowired
	RemoteCallHelper remoteCallHelper;

	@Autowired
	WeatherLookupRepository weatherLookupRepository;

	@Override
	public WeatherInfo getCurrentWeatherInfo(String cityName) throws Exception {

		String response = remoteCallHelper.getWeatherInfo(cityName);
		JsonParsingUtility.checkResponseStatus(response);

		return weatherLookupRepository.save(JsonParsingUtility.getWeatherInfo(response, cityName));
	}

	@Override
	public HistoricalWeatherInfo getHistoricalWeatherInfo(String cityName) {

		if (cityName.contains(Constants.COMMA)) {
			String[] twoStringArray = cityName.split(Constants.COMMA, 2);
			cityName = twoStringArray[0];
		}

		HistoricalWeatherInfo historicalInfo = null;
		List<WeatherInfo> weatherHistory = weatherLookupRepository
				.findFirst5ByCityContainingOrderByCreatedDesc(cityName);

		if (weatherHistory.size() != 0) {
			historicalInfo = new HistoricalWeatherInfo();

			double averageTemp = weatherHistory.stream().collect(Collectors.averagingDouble(WeatherInfo::getTemp));

			double averagePressure = weatherHistory.stream()
					.collect(Collectors.averagingInt(WeatherInfo::getPressure));

			historicalInfo.setAvg_temp(averageTemp);
			historicalInfo.setAvg_pressure(averagePressure);
			historicalInfo.setHistory(weatherHistory);
		}

		return historicalInfo;
	}
}
