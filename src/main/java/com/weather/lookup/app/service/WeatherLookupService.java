package com.weather.lookup.app.service;

import java.util.List;

import com.weather.lookup.app.domain.WeatherInfo;

public interface WeatherLookupService {
	
	WeatherInfo getCurrentWeatherInfo(String cityName) throws Exception;
	
	List<WeatherInfo> getHistoricalWeatherInfo();
}
