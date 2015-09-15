package com.shma.iterator;

import java.util.Vector;


public class ConcreteIterable<T> implements Iterable<T> {

	private Vector<T> vector;
	
	public ConcreteIterable(final Vector<T> vector) {
		super();
		this.vector = vector;
	}

	@Override
	public Iterator<T> createIterator() {
		return new ConcreteIterator<T>(vector);
	}

	public Vector<T> getVector() {
		return vector;
	}

	public void setVector(Vector<T> vector) {
		this.vector = vector;
	}

}
