package com.weather.lookup.app.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RemoteCallHelper {

	@Value("${api.key}")
	private String apiKey;

	private final WebClient webClient;

	public RemoteCallHelper() {
		this.webClient = WebClient.builder().baseUrl(Constants.WEATHER_API_URL).build();
	}

	public String getWeatherInfo(String cityName) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path(Constants.WEATHER_URI)
						.queryParam(Constants.WEATHER_QUERY_PARAM_Q, cityName)
						.queryParam(Constants.WEATHER_QUERY_PARAM_APP_ID, apiKey)
						.queryParam(Constants.WEATHER_QUERY_PARAM_UNIT, Constants.UNIT_OF_MEASUREMENT).build())
				.exchange().block().bodyToMono(String.class).block();
	}

}
