package com.weather.lookup.app.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Test;

import com.weather.lookup.app.common.MVCIntegrationTest;

public class WeatherLookupControllerItest extends MVCIntegrationTest{
	
//	@Test
//	public void getHelloIsOKAndReturnsValidJSON() throws Exception {
//		mockMvc.perform(get("/hello"))
//		       .andExpect(status().isOk())
//		       .andExpect(jsonPath("$.id", is(DEFAULT_ID)))
//		       .andExpect(jsonPath("$.message", is(DEFAULT_MESSAGE)));
//	}
//	
//	@Test
//	public void getHelloWithRandomIdReturnsNotFound() throws Exception{
//		UUID randomId = UUID.randomUUID();
//		mockMvc.perform(get("/hello/"+ randomId))
//				.andExpect(status().isNotFound())
//				.andExpect(jsonPath("$.message", containsString(GREETING_NOT_FOUND)));
//	}

}
