package com.weather.lookup.app.controller;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.lookup.app.common.MVCIntegrationTest;
import com.weather.lookup.app.utility.Constants;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherLookupControllerIntegrationTest extends MVCIntegrationTest{
	
	@Test
	public void getCurrentWeatherWhenLocationIsEmpty() throws Exception {
		mockMvc.perform(get("/weatherlookup/current?location="))
		       .andExpect(status().isBadRequest())
		       .andExpect(jsonPath("$.message", containsString(Constants.MESSAGE_INVALID_CITY_NAME)));
	}
	
	@Test
	public void getCurrentWeatherWhenLocationIsValid() throws Exception {
		String location= "London";
		
		mockMvc.perform(get("/weatherlookup/current?location=" + location))
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$.temp", isA(Double.class)));
	}

}
