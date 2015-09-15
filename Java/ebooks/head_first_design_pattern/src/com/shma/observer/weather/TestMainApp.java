package com.shma.observer.weather;


public class TestMainApp {

	public static void main(String[] args) {
		//����һ�����۲��߶���
		WeatherData weatherData = new WeatherData();
		
		//���������۲������
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		
		//�����һ���۲������
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		weatherData.setMeasurements(82, 70, 29.2f);
		
		//�Ƴ�һ���۲������
		forecastDisplay.remove();
		weatherData.setMeasurements(78, 90, 29.2f);
		
		
	}
}
