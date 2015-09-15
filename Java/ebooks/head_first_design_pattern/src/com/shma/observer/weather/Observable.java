package com.shma.observer.weather;

import java.util.Vector;

public abstract class Observable implements Subject {

	private boolean isChanged = false;
	private Vector<Observer> vector;
	
	public Observable() {
		vector = new Vector<Observer>();
	}
	
	@Override
	public synchronized void registerObserver(Observer o) {
		if (o == null)
            throw new NullPointerException();
		if(!vector.contains(o)) {
			vector.add(o);
		}
	}

	@Override
	public synchronized void removeObserver(Observer o) {
		if (o == null)
            throw new NullPointerException();
		if(vector.contains(o)) {
			vector.remove(o);
		}
	}

	@Override
	public synchronized void notifyObservers() {
		notifyObservers(null);
	}

	@Override
	public void notifyObservers(Object obj) {
		synchronized(this) {
			if(!isChanged) {
				return;
			}
			
			isChanged = false;
		}
		for(Observer observer : vector) {
			observer.update(this, obj);
		}
	}

	public synchronized boolean isChanged() {
		return isChanged;
	}

	protected synchronized void setChanged() {
		isChanged = true;
	}
	
	protected synchronized void clearChanged() {
		isChanged = false;
	}

}
