package com.shma.observer.weather;

/**
 * �������⣨Subject����ɫ
 * @author admin
 *
 */
public interface Subject {

	/**
	 * ע��һ���۲���
	 * @param o
	 */
	public void registerObserver(Observer o);
	
	/**
	 * �Ƴ�һ���۲���
	 * @param o
	 */
	public void removeObserver(Observer o);
	
	/**
	 * ֪ͨ�۲���
	 */
	public void notifyObservers();
	public void notifyObservers(Object obj);
	
}
