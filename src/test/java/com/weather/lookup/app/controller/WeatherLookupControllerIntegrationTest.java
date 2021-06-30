package com.weather.lookup.app.controller;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.lookup.app.common.MVCIntegrationTest;
import com.weather.lookup.app.test.helper.TestConstants;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherLookupControllerIntegrationTest extends MVCIntegrationTest {

	@Test
	public void getCurrentWeatherWhenLocationIsEmpty() throws Exception {
		mockMvc.perform(get(TestConstants.CURRENT_WEATHER_CHECK_URI)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message", isA(String.class))).andExpect(jsonPath("$.temp").doesNotExist());
	}

	@Test
	public void getCurrentWeatherWhenLocationIsNotValid() throws Exception {
		mockMvc.perform(get(TestConstants.CURRENT_WEATHER_CHECK_URI + TestConstants.TEST_RANDOM_NAME)).andExpect(status().isInternalServerError())
				.andExpect(jsonPath("$.message", isA(String.class))).andExpect(jsonPath("$.temp").doesNotExist());
	}

	@Test
	public void getCurrentWeatherWhenLocationIsValid() throws Exception {
		mockMvc.perform(get(TestConstants.CURRENT_WEATHER_CHECK_URI + TestConstants.TEST_CITY)).andExpect(status().isOk())
				.andExpect(jsonPath("$.temp", isA(Double.class))).andExpect(jsonPath("$.umbrella", isA(Boolean.class)))
				.andExpect(jsonPath("$.pressure", isA(Integer.class))).andExpect(jsonPath("$.message").doesNotExist());
	}
	
	@Test
	public void getHistoricalWeatherWhenLocationIsEmpty() throws Exception {
		mockMvc.perform(get(TestConstants.HISTORICAL_WEATHER_CHECK_URI)).andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.message", isA(String.class))).andExpect(jsonPath("$.temp").doesNotExist());
	}
	
	@Test
	public void getHistoricalWeatherWhenLocationIsValid() throws Exception {
		mockMvc.perform(get(TestConstants.HISTORICAL_WEATHER_CHECK_URI + TestConstants.TEST_CITY)).andExpect(status().isOk())
		.andExpect(jsonPath("$.avg_temp", isA(Double.class)))
		.andExpect(jsonPath("$.avg_pressure", isA(Double.class)))
		.andExpect(jsonPath("$.history", hasSize(greaterThanOrEqualTo(1))))
		.andExpect(jsonPath("$.message").doesNotExist());
	}
}
