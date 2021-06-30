package com.weather.lookup.app.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "weatherinfo")
public class WeatherInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private double temp;
	private int pressure;
	private boolean umbrella;
	@JsonIgnore
	private String city;
	@CreationTimestamp
	@JsonIgnore
    private LocalDateTime created;
	
	public WeatherInfo(double temp, int pressure, boolean umbrella, String city) {
		super();
		this.temp = temp;
		this.pressure = pressure;
		this.umbrella = umbrella;
		this.city = city;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "WeatherInfo [id=" + id + ", temp=" + temp + ", pressure=" + pressure + ", umbrella=" + umbrella
				+ ", city=" + city + ", created=" + created + "]";
	}

}
