package com.shma.adapter.iterenum;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class TestMainApp {

	public static void main(String[] args) {
		String[] names = {"ÂíÉØ»ª", "Æë½¿½¿", "ËïÍþ", "·®»Û"};
		
		Vector<String> vectorNames = new Vector<String>(Arrays.asList(names));
		
		Iterator<String> iterator = new EnumerationIterator<String>(vectorNames.elements());
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		Enumeration<String> enumeration = new IteratorEnumeration<String>(vectorNames.iterator());
		
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
			
		}
	}
}
