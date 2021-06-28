package com.weather.lookup.app.domain;

import java.util.List;

public class HistoricalWeatherInfo {

	private int avg_temp;
	private int avg_pressure;
	private List<WeatherInfo> history;

	public int getAvg_temp() {
		return avg_temp;
	}

	public void setAvg_temp(int avg_temp) {
		this.avg_temp = avg_temp;
	}

	public int getAvg_pressure() {
		return avg_pressure;
	}

	public void setAvg_pressure(int avg_pressure) {
		this.avg_pressure = avg_pressure;
	}

	public List<WeatherInfo> getHistory() {
		return history;
	}

	public void setHistory(List<WeatherInfo> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "HistoricalWeatherInfo [avg_temp=" + avg_temp + ", avg_pressure=" + avg_pressure + ", history=" + history
				+ "]";
	}

}
