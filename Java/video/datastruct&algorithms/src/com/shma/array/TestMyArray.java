package com.shma.array;

import org.junit.Test;

public class TestMyArray {

	@Test
	public void test() {
		MyArray<Integer> myArray = new MyArray<Integer>(Integer.class);
		myArray.insert(10);
		myArray.insert(30);
		myArray.insert(22);
		myArray.insert(26);
		myArray.insert(29);
		myArray.insert(31);
		
		myArray.display();
		
		System.out.println(myArray.del(2));
		myArray.display();
		
		System.out.println(myArray.update(1,  99));
		myArray.display();
		
		System.out.println(myArray.get(1));
		
		System.out.println(myArray.search(31));
	}
	
	@Test
	public void orderTest() {
		MyArray<Integer> myArray = new MyArray<Integer>(Integer.class);
		myArray.insertByOrder(10);
		myArray.insertByOrder(30);
		myArray.insertByOrder(22);
		myArray.insertByOrder(26);
		myArray.insertByOrder(29);
		myArray.insertByOrder(31);
		myArray.insertByOrder(7);
		myArray.display();
		
		System.out.println(myArray.binarySearch(29));
	}

}
