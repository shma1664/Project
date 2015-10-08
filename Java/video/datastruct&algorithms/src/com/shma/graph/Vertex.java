package com.shma.graph;

/**
 * ¶¥µãÀà
 * @author h p
 *
 */
public class Vertex<T> {

	private T data;
	private boolean isVisited = false;
	
	public Vertex(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
}
