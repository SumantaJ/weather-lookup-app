package com.weather.lookup.app.utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import com.weather.lookup.app.domain.WeatherInfo;

public class JsonParsingUtility {

	public static void checkResponseStatus(String response) throws Exception {
		JSONObject obj = new JSONObject(response);

		if (obj.getInt(Constants.JSON_TAG_COD) != HttpStatus.OK.value()) {
			throw new Exception(obj.getString(Constants.JSON_TAG_MESSAGE));
		}
	}

	public static WeatherInfo getWeatherInfo(String response, String cityName) throws JSONException {
		JSONObject obj = new JSONObject(response);
		WeatherInfo weatherInfo = new WeatherInfo();

		JSONObject main = obj.getJSONObject(Constants.JSON_TAG_MAIN);
		JSONArray weather = obj.getJSONArray(Constants.JSON_TAG_WEATHER);
		
		String mainString = weather.getJSONObject(0).getString(Constants.JSON_TAG_MAIN);

		weatherInfo.setTemp(main.getDouble(Constants.JSON_TAG_TEMP));
		weatherInfo.setPressure(main.getInt(Constants.JSON_TAG_PRESSURE));
		weatherInfo.setCity(cityName);

		setIsUmbrellaRequired(weatherInfo, mainString);

		return weatherInfo;
	}

	private static void setIsUmbrellaRequired(WeatherInfo info, String value) {
		info.setUmbrella(WeatherTypeEnum.fromValue(value));
	}
}