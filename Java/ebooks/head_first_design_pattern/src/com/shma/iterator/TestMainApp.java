package com.shma.iterator;

import java.util.Vector;

public class TestMainApp {

	public static void main(String[] args) {
		
		Vector<String> vector = new Vector<String>();
		vector.add("ÂíÉØ»ª");
		vector.add("Æë½¿½¿");
		vector.add("ËïÍş");
		vector.add("ÖÜÎ°");
		vector.add("ºîÑà");
		
		final Iterable<String> iterable = new ConcreteIterable<String>(vector);
		
		final Iterator<String> iterator = iterable.createIterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
