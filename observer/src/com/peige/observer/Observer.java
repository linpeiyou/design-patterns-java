package com.peige.observer;

public interface Observer {
	
	/**
	 * 更新布告板
	 * @param temp		温度
	 * @param humidity	湿度
	 * @param pressure	气压 
	 */
	void update(float temp, float humidity, float pressure);

}
