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

@RunWith(MockitoJUnitRunner.class)
public class WeatherLookupControllerJunitTest {

	private static final String TEST_CITY = "London,uk";
	private static final int TEST_PRESSURE = 32;
	private static final double TEST_TEMP = 1245.0;
	private static final boolean TEST_UMBRELLA = true;

	@Mock
	WeatherLookupService weatherLookupService;

	@InjectMocks
	WeatherLookupController weatherLookupController;

	@Test
	public void getCurrentWeatherInfo() throws Exception {
		Mockito.when(weatherLookupService.getCurrentWeatherInfo(TEST_CITY))
				.thenReturn(new WeatherInfo(TEST_TEMP, TEST_PRESSURE, TEST_UMBRELLA, TEST_CITY));

		WeatherInfo responseEntity = weatherLookupController.getCurrentWeatherInfo(TEST_CITY);
		Assert.assertSame(TEST_UMBRELLA, responseEntity.isUmbrella());
	}

	@Test(expected = IllegalArgumentException.class)
	public void getCurrentWeatherInfoWhenCityEmpty() throws Exception {
		weatherLookupController.getCurrentWeatherInfo("");
	}

	@Test
	public void getHistoricalWeatherInfo() throws Exception {
		Mockito.when(weatherLookupService.getHistoricalWeatherInfo(TEST_CITY))
				.thenReturn(new HistoricalWeatherInfo(TEST_TEMP, TEST_PRESSURE, new ArrayList<>()));

		HistoricalWeatherInfo responseEntity = weatherLookupController.getHistoricalWeatherInfo(TEST_CITY);
		Assert.assertTrue(TEST_TEMP == responseEntity.getAvg_temp());
	}

	@Test(expected = IllegalArgumentException.class)
	public void getHistoricalWeatherInfoWhenCityEmpty() throws Exception {
		weatherLookupController.getHistoricalWeatherInfo("");
	}

}
