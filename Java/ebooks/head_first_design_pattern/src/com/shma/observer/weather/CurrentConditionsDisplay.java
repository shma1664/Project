package com.shma.observer.weather;

/**
 * ����۲��ߣ�ConcreteObserver����ɫ
 * @author admin
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private Observable observable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature 
				+ "F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(Subject subject, Object obj) {
		if(subject instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)subject;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
		
	}

	@Override
	public void remove() {
		observable.removeObserver(this);
	}

}
