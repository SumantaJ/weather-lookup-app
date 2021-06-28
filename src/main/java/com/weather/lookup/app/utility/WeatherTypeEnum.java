package com.weather.lookup.app.utility;

public enum WeatherTypeEnum {

	THUNDERSTORM("Thunderstorm"), DRIZZLE("Drizzle"), RAIN("Rain");

	private String value;

	WeatherTypeEnum(String value) {
		this.value = value;
	}

	public static boolean fromValue(String value) {
		for (WeatherTypeEnum b : WeatherTypeEnum.values()) {
			if (b.value.equals(value)) {
				return true;
			}
		}
		return false;
	}
}
