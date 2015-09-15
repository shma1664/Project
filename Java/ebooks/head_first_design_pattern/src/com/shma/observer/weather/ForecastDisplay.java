package com.shma.observer.weather;

/*
* 具体观察者（ConcreteObserver）角色
* @author admin
*
*/
public class ForecastDisplay implements Observer, DisplayElement {
	private Observable observable;
	private float currentPressure = 29.92f;  
	private float lastPressure;

	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.registerObserver(this);
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

	@Override
	public void update(Subject subject, Object obj) {
		if (subject instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)subject;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
		}
	}

	@Override
	public void remove() {
		observable.removeObserver(this);
	}
}
