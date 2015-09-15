package com.shma.iterator;

import java.util.Vector;

public class ConcreteIterator<T> implements Iterator<T> {

	private Vector<T> vector = null;
	
	private int currIndex = 0;
	
	public ConcreteIterator(final Vector<T> vector) {
		super();
		this.vector = vector;
	}

	@Override
	public T next() {
		return vector.get(currIndex++);
	}

	@Override
	public boolean hasNext() {
		return currIndex < vector.size() ? true : false;
	}

	@Override
	public void remove() {
		vector.remove(currIndex);
	}

}
