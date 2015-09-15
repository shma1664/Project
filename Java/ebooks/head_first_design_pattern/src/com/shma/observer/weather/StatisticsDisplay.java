package com.shma.observer.weather;

public class StatisticsDisplay implements Observer, DisplayElement {
	private Observable observable;
	
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.registerObserver(this);
	}

	public void update(Subject subject, Object arg) {
		if (subject instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)subject;
			float temp = weatherData.getTemperature();
			tempSum += temp;
			numReadings++;

			if (temp > maxTemp) {
				maxTemp = temp;
			}
 
			if (temp < minTemp) {
				minTemp = temp;
			}

			display();
		}
	}

	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}

	@Override
	public void remove() {
		observable.removeObserver(this);
	}
}

