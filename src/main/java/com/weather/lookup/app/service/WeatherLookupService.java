package com.weather.lookup.app.service;

import com.weather.lookup.app.domain.HistoricalWeatherInfo;
import com.weather.lookup.app.domain.WeatherInfo;

public interface WeatherLookupService {
	
	WeatherInfo getCurrentWeatherInfo(String cityName) throws Exception;

	HistoricalWeatherInfo getHistoricalWeatherInfo(String cityName) throws Exception;
}
