package com.shma.iterator;

import java.util.Vector;

public class TestMainApp {

	public static void main(String[] args) {
		
		Vector<String> vector = new Vector<String>();
		vector.add("���ػ�");
		vector.add("�뽿��");
		vector.add("����");
		vector.add("��ΰ");
		vector.add("����");
		
		final Iterable<String> iterable = new ConcreteIterable<String>(vector);
		
		final Iterator<String> iterator = iterable.createIterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
