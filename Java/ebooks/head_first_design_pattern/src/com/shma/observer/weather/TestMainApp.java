package com.shma.observer.weather;


public class TestMainApp {

	public static void main(String[] args) {
		//创建一个被观察者对象
		WeatherData weatherData = new WeatherData();
		
		//创建三个观察者面板
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		
		//又添加一个观察者面板
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		weatherData.setMeasurements(82, 70, 29.2f);
		
		//移除一个观察者面板
		forecastDisplay.remove();
		weatherData.setMeasurements(78, 90, 29.2f);
		
		
	}
}
