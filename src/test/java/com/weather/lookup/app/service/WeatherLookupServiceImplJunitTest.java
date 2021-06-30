package com.weather.lookup.app.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.weather.lookup.app.dao.WeatherLookupRepository;
import com.weather.lookup.app.domain.HistoricalWeatherInfo;
import com.weather.lookup.app.domain.WeatherInfo;
import com.weather.lookup.app.service.impl.WeatherLookupServiceImpl;
import com.weather.lookup.app.test.helper.TestConstants;
import com.weather.lookup.app.utility.RemoteCallHelper;

@RunWith(MockitoJUnitRunner.class)
public class WeatherLookupServiceImplJunitTest {

	@Mock
	WeatherLookupRepository weatherLookupRepository;

	@Mock
	RemoteCallHelper remoteCallHelper;

	@InjectMocks
	WeatherLookupServiceImpl weatherLookupService;

	@Test
	public void getCurrentWeatherInfo() throws Exception {
		Mockito.when(remoteCallHelper.getWeatherInfo(TestConstants.TEST_CITY))
				.thenReturn(TestConstants.SAMPLE_SUCCESFULL_RESPONSE);

		WeatherInfo responseEntity = weatherLookupService.getCurrentWeatherInfo(TestConstants.TEST_CITY);

		Assert.assertFalse(responseEntity.getCity().isEmpty());
	}

	@Test(expected = Exception.class)
	public void getCurrentWeatherInfoWhenCityDoesNotExist() throws Exception {
		weatherLookupService.getCurrentWeatherInfo(TestConstants.TEST_CITY);
	}

	@Test
	public void getHistoricalWeatherInfo() throws Exception {
		Mockito.when(weatherLookupRepository.findFirst5ByCityContainingOrderByCreatedDesc(TestConstants.TEST_CITY2))
				.thenReturn(getWeatherInfoDummyResponse());

		HistoricalWeatherInfo responseEntity = weatherLookupService.getHistoricalWeatherInfo(TestConstants.TEST_CITY2);

		Assert.assertTrue(responseEntity.getHistory().size() != 0);
	}
	
	@Test(expected = Exception.class)
	public void getHistoricalWeatherInfoWhenHistoryDoesNotExist() throws Exception {
		weatherLookupService.getHistoricalWeatherInfo(TestConstants.TEST_RANDOM_NAME);
	}

	private List<WeatherInfo> getWeatherInfoDummyResponse() {
		List<WeatherInfo> weatherInfoDataList = new ArrayList<>();

		WeatherInfo weatherInfoOne = new WeatherInfo(TestConstants.TEST_TEMP, TestConstants.TEST_PRESSURE,
				TestConstants.TEST_UMBRELLA, TestConstants.TEST_CITY);

		weatherInfoDataList.add(weatherInfoOne);

		return weatherInfoDataList;
	}

}
