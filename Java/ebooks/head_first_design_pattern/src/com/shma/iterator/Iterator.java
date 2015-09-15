package com.shma.iterator;

public interface Iterator<T> {

	public T next();
	
	public boolean hasNext();
	
	public void remove();
}
