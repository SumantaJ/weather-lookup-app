package com.weather.lookup.app.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.lookup.app.domain.HistoricalWeatherInfo;
import com.weather.lookup.app.domain.WeatherInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherLookupServiceImplIntegrationTest {
	
	private static final String TEST_CITY = "London,uk";

	@Autowired
	private WeatherLookupService weatherLookupService;
	

	@Test
	public void getCurrentWeatherInfoWhenValid() throws Exception {
		WeatherInfo weatherInfo = weatherLookupService.getCurrentWeatherInfo(TEST_CITY);
		
		Assert.assertTrue((weatherInfo.getTemp() != 0));
		Assert.assertTrue(weatherInfo.getPressure() != 0);
	}
	
	@Test
	public void getHistoricalWeatherInfoWhenValid() throws Exception {
		HistoricalWeatherInfo weatherInfo = weatherLookupService.getHistoricalWeatherInfo(TEST_CITY);
		
		Assert.assertTrue((weatherInfo.getAvg_temp() > 0));
		Assert.assertTrue(weatherInfo.getAvg_pressure() > 0);
		Assert.assertTrue(weatherInfo.getHistory().size() == 5);
	}

}
