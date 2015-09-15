package com.shma.observer.weather;

/**
 * 抽象观察者（Observer）角色
 * @author admin
 *
 */
public interface Observer {

	public void update(Subject subject, Object obj);
	
	public void remove();
}
