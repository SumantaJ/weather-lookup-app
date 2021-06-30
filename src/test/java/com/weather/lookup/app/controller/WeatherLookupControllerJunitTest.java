package com.weather.lookup.app.controller;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.weather.lookup.app.domain.HistoricalWeatherInfo;
import com.weather.lookup.app.domain.WeatherInfo;
import com.weather.lookup.app.service.WeatherLookupService;
import com.weather.lookup.app.test.helper.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class WeatherLookupControllerJunitTest {

	@Mock
	WeatherLookupService weatherLookupService;

	@InjectMocks
	WeatherLookupController weatherLookupController;

	@Test
	public void getCurrentWeatherInfo() throws Exception {
		Mockito.when(weatherLookupService.getCurrentWeatherInfo(TestConstants.TEST_CITY))
				.thenReturn(new WeatherInfo(TestConstants.TEST_TEMP, TestConstants.TEST_PRESSURE, 
						TestConstants.TEST_UMBRELLA, TestConstants.TEST_CITY));

		WeatherInfo responseEntity = weatherLookupController.getCurrentWeatherInfo(TestConstants.TEST_CITY);
		Assert.assertSame(TestConstants.TEST_UMBRELLA, responseEntity.isUmbrella());
	}

	@Test(expected = IllegalArgumentException.class)
	public void getCurrentWeatherInfoWhenCityEmpty() throws Exception {
		weatherLookupController.getCurrentWeatherInfo("");
	}

	@Test
	public void getHistoricalWeatherInfo() throws Exception {
		Mockito.when(weatherLookupService.getHistoricalWeatherInfo(TestConstants.TEST_CITY))
				.thenReturn(new HistoricalWeatherInfo(TestConstants.TEST_TEMP, TestConstants.TEST_PRESSURE, new ArrayList<>()));

		HistoricalWeatherInfo responseEntity = weatherLookupController.getHistoricalWeatherInfo(TestConstants.TEST_CITY);
		Assert.assertTrue(TestConstants.TEST_TEMP == responseEntity.getAvg_temp());
	}

	@Test(expected = IllegalArgumentException.class)
	public void getHistoricalWeatherInfoWhenCityEmpty() throws Exception {
		weatherLookupController.getHistoricalWeatherInfo("");
	}

}
