package com.shma.concurrency.chapter06.recipe03;

import com.google.common.primitives.Ints;

public class Event implements Comparable<Event> {

	private String name;
	
	private int priority;
	
	public Event(String name, int priority) {
		super();
		this.name = name;
		this.priority = priority;
	}

	@Override
	public int compareTo(Event event) {
		
		return Ints.compare(event.priority, this.priority);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
