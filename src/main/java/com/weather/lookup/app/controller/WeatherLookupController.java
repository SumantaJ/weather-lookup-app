package com.weather.lookup.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.lookup.app.domain.HistoricalWeatherInfo;
import com.weather.lookup.app.domain.WeatherInfo;
import com.weather.lookup.app.service.WeatherLookupService;
import com.weather.lookup.app.utility.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/weatherlookup")
@Api(value = "Weather Lookup Controller")
public class WeatherLookupController {

	@Autowired
	WeatherLookupService weatherLookupService;

	/**
	 * This Controller takes city name and returns weather information including
	 * umbrella usage requirement
	 * 
	 * @param cityName
	 * @return result object containing weather info
	 * @throws Exception
	 */
	@ApiOperation(value = "Find current temperature and umbrella requirement.", response = WeatherInfo.class)
	@GetMapping(value = "/current", produces = { MediaType.APPLICATION_JSON_VALUE })
	WeatherInfo getCurrentWeatherInfo(@RequestParam(name = "location") String cityName) throws Exception {

		if (cityName.trim().isEmpty()) {
			throw new IllegalArgumentException(Constants.MESSAGE_INVALID_CITY_NAME);
		}

		return weatherLookupService.getCurrentWeatherInfo(cityName.trim());
	}

	/**
	 * This Controller takes city name and returns last 5 search history with
	 * average temperature and pressure
	 * 
	 * @param cityName
	 * @return result object containing historical weather info
	 * @throws Exception
	 */
	@ApiOperation(value = "Find historical average of last 5 search", response = HistoricalWeatherInfo.class)
	@GetMapping(value = "/history", produces = { MediaType.APPLICATION_JSON_VALUE })
	HistoricalWeatherInfo getHistoricalWeatherInfo(@RequestParam(name = "location") String cityName) throws Exception {

		if (cityName.trim().isEmpty()) {
			throw new IllegalArgumentException(Constants.MESSAGE_INVALID_CITY_NAME);
		}

		return weatherLookupService.getHistoricalWeatherInfo(cityName.trim());
	}

}
