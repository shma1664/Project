package com.shma.chapter14.activeobject;

import com.shma.chapter14.future.Future;

public interface IActiveObject<T> {
	
	public Future<T> make(int count, char fillchar);
	
	public void display(String string);
}
