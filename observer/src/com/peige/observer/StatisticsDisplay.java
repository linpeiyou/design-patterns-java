package com.peige.observer;

import com.peige.display.DisplayElement;
import com.peige.subject.Subject;

public class StatisticsDisplay implements DisplayElement, Observer {

	private float avgTemp;
	private float maxTemp;
	private float minTemp;
	private int count;		// 不考虑溢出
	private Subject weatherData;
	
	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
		avgTemp = 0.0f;
		maxTemp = Float.MIN_VALUE;
		minTemp = Float.MAX_VALUE;
		count = 0;
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		if(temp > maxTemp)
			maxTemp = temp;
		if(temp < minTemp)
			minTemp = temp;
		avgTemp = (avgTemp * count + temp) / (count + 1);
		++count;
		display();
	}

	@Override
	public void display() {
		System.out.printf("Avg/Max/Min temperture = %.1f/%.1f/%.1f%n", avgTemp, maxTemp, minTemp);
	}

}
