package com.weather.lookup.app.utility;

public class Constants {

	public static final String WEATHER_API_URL = "http://api.openweathermap.org";
	public static final String WEATHER_URI= "/data/2.5/weather";
	public static final String WEATHER_QUERY_PARAM_Q = "q";
	public static final String WEATHER_QUERY_PARAM_APP_ID = "appid";
	public static final String WEATHER_QUERY_PARAM_UNIT = "units";
	public static final String UNIT_OF_MEASUREMENT = "metric";
	
	//Exception message
	public static final String MESSAGE_INVALID_CITY_NAME = "Please provide valid city name";
	
	//Json Tags
	public static final String JSON_TAG_COD = "cod";
	public static final String JSON_TAG_MESSAGE = "message";
	public static final String JSON_TAG_MAIN = "main";
	public static final String JSON_TAG_TEMP = "temp";
	public static final String JSON_TAG_PRESSURE = "pressure";
	public static final String JSON_TAG_WEATHER = "weather";
	
	//Character
	public static final String COMMA = ",";

}
