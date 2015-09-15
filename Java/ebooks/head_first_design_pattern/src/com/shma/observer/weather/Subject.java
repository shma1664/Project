package com.shma.observer.weather;

/**
 * 抽象主题（Subject）角色
 * @author admin
 *
 */
public interface Subject {

	/**
	 * 注册一个观察者
	 * @param o
	 */
	public void registerObserver(Observer o);
	
	/**
	 * 移除一个观察者
	 * @param o
	 */
	public void removeObserver(Observer o);
	
	/**
	 * 通知观察者
	 */
	public void notifyObservers();
	public void notifyObservers(Object obj);
	
}
