package com.nilerbarcelos.model;

import java.util.List;

public class Item {

	private String dt;
	private Temperatura temp;
	private String humidity;
	private List<Clima> weather;
	
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public Temperatura getTemp() {
		return temp;
	}
	public void setTemp(Temperatura temp) {
		this.temp = temp;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public List<Clima> getWeather() {
		return weather;
	}
	public void setWeather(List<Clima> weather) {
		this.weather = weather;
	}	
}