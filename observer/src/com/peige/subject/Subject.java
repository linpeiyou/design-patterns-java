package com.peige.subject;

import com.peige.observer.Observer;

public interface Subject {
	
	/**
	 * 注册观察者
	 * @param o 观察者
	 */
	void registerObserver(Observer o);
	
	/**
	 * 删除观察者
	 * @param o 观察者
	 */
	void removeObserver(Observer o);
	
	/**
	 * 当主题状态改变时，这个方法会被调用，以通知所有的观察者
	 */
	void notifyObservers();

}
