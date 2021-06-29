package com.weather.lookup.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.weather.lookup.app.domain.WeatherInfo;
import com.weather.lookup.app.service.WeatherLookupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/weatherlookup")
@Api(value = "Weather Lookup Controller")
public class WeatherLookupController {
	
	@Autowired
	WeatherLookupService weatherLookupService;

	/**
	 * This Controller takes city name and returns weather information including umbrella usage requirement
	 * 
	 * @param parameterizedUrls
	 * @return result containing parameterzied urls mapping and error list for which mapping not found
	 */
	@ApiOperation(value = "find current temperature and umbrella requirement.", response = WeatherInfo.class)
	@GetMapping(value = "/current")
	WeatherInfo getCurrentWeatherInfo(@RequestParam(name = "location") String cityName) {

		if (cityName.trim().isEmpty()) {
			throw new IllegalArgumentException("{\"error\":\"Please provide valid city name\"}");
		}

		WeatherInfo weatherInfo;
		try {
			weatherInfo = weatherLookupService.getCurrentWeatherInfo(cityName.trim());
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return weatherInfo;
	}

	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final String exceptionHandlerIllegalArgumentException(final IllegalArgumentException e) {
	    return '"' + e.getMessage() + '"';
	}

}
