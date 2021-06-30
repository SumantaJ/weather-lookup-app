package com.weather.lookup.app.test.helper;

public class TestConstants {

	public static final String CURRENT_WEATHER_CHECK_URI = "/weatherlookup/current?location=";
	public static final String HISTORICAL_WEATHER_CHECK_URI = "/weatherlookup/history?location=";
	public static final String TEST_CITY = "London,uk";
	public static final String TEST_CITY2 = "London";
	public static final String TEST_RANDOM_NAME = "Test";
	public static final int TEST_PRESSURE = 32;
	public static final double TEST_TEMP = 1245.0;
	public static final boolean TEST_UMBRELLA = true;
	public static final double TEST_AVG_PRESSURE = 32.76;
	public static final double TEST_AVG_TEMP = 15.97;

	public static final String SAMPLE_SUCCESFULL_RESPONSE= "{\"coord\":{\"lon\":13.4105,\"lat\":52.5244},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\","
			+ "\"icon\":\"10n\"}],\"base\":\"stations\",\"main\":{\"temp\":16.94,\"feels_like\":17.14,\"temp_min\":15.98,\"temp_max\":17.84,\"pressure\":1006,\"humidity\":94},"
			+ "\"visibility\":10000,\"wind\":{\"speed\":4.92,\"deg\":248,\"gust\":6.71},\"rain\":{\"1h\":0.89},\"clouds\":{\"all\":75},\"dt\":1625086186,\"sys\":{\"type\":2,\"id\":2011538,"
			+ "\"country\":\"DE\",\"sunrise\":1625021219,\"sunset\":1625081568},\"timezone\":7200,\"id\":2950159,\"name\":\"Berlin\",\"cod\":200}";
	
	public static final String SAMPLE_FAILURE_RESPONSE= "{\"cod\":\"404\",\"message\":\"city not found\"}";

}
