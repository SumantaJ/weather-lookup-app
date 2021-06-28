package com.weather.lookup.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "weatherinfo")
public class WeatherInfo {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	private double temp;
	private int pressure;
	private boolean umbrella;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public boolean isUmbrella() {
		return umbrella;
	}

	public void setUmbrella(boolean umbrella) {
		this.umbrella = umbrella;
	}

	@Override
	public String toString() {
		return "WeatherInfo [id=" + id + ", temp=" + temp + ", pressure=" + pressure + ", umbrella=" + umbrella + "]";
	}

}
