package com.peige.test;

import com.peige.observer.CurrentConditionsDisplay;
import com.peige.observer.ForecastDisplay;
import com.peige.observer.Observer;
import com.peige.observer.StatisticsDisplay;
import com.peige.subject.Subject;
import com.peige.subject.WeatherData;

public class Test {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		Observer currentConditionsDisplay = 
				new CurrentConditionsDisplay(weatherData);
		Observer statisticsDisplay = new StatisticsDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);		
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
	
}
