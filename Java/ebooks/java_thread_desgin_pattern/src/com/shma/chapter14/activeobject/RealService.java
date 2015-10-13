package com.shma.chapter14.activeobject;

import com.shma.chapter14.future.Future;

public class RealService<T> implements IActiveObject<T> {

	@Override
	public Future<T> make(int count, char fillchar) {
		char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = fillchar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
		return null;
	}

	@Override
	public void display(String string) {
		
	}

}
