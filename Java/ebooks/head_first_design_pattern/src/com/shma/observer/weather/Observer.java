package com.shma.observer.weather;

/**
 * ����۲��ߣ�Observer����ɫ
 * @author admin
 *
 */
public interface Observer {

	public void update(Subject subject, Object obj);
	
	public void remove();
}
