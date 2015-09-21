package com.shma.recursive;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void test() {
		System.out.println(Triangle.getNumber(1));
		System.out.println(Triangle.getNumberByRecursive(1));
		
		System.out.println(Triangle.getNumber(10));
		System.out.println(Triangle.getNumberByRecursive(10));
		
		System.out.println(Triangle.getNumber(200));
		System.out.println(Triangle.getNumberByRecursive(200));
	}

}
