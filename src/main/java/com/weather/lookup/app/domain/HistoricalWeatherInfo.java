package com.weather.lookup.app.domain;

import java.util.ArrayList;
import java.util.List;

public class HistoricalWeatherInfo {

	private double avg_temp;
	private double avg_pressure;
	private List<WeatherInfo> history = new ArrayList<>();
	
	public HistoricalWeatherInfo(double avg_temp, double avg_pressure, List<WeatherInfo> history) {
		super();
		this.avg_temp = avg_temp;
		this.avg_pressure = avg_pressure;
		this.history = history;
	}

	public HistoricalWeatherInfo() {
	}

	public double getAvg_temp() {
		return avg_temp;
	}

	public void setAvg_temp(double avg_temp) {
		this.avg_temp = avg_temp;
	}

	public double getAvg_pressure() {
		return avg_pressure;
	}

	public void setAvg_pressure(double avg_pressure) {
		this.avg_pressure = avg_pressure;
	}

	public List<WeatherInfo> getHistory() {
		return history;
	}

	public void setHistory(List<WeatherInfo> history) {
		this.history.addAll(history);
	}

	@Override
	public String toString() {
		return "HistoricalWeatherInfo [avg_temp=" + avg_temp + ", avg_pressure=" + avg_pressure + ", history=" + history
				+ "]";
	}

}
