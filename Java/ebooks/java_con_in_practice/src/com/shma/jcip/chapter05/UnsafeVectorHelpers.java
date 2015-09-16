package com.shma.jcip.chapter05;

import java.util.Vector;

import com.shma.jcip.annotation.NotThreadSafe;

@NotThreadSafe
public class UnsafeVectorHelpers {

	public static Object getLast(Vector<String> list) {
		int lastIndex = list.size() - 1;
		return list.get(lastIndex);
	}
	
	public static void deleteLast(Vector<String> list) {
		int lastIndex = list.size() - 1;
		list.remove(lastIndex);
	}
}
