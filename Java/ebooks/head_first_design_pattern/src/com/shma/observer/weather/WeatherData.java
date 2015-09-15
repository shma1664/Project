package com.shma.observer.weather;

/**
 * 具体主题（ConcreteSubject）角色
 * @author admin
 *
 */
public class WeatherData extends Observable {

	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		
	}
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
