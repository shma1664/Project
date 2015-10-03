package com.shma.hash;

import org.junit.Test;

public class HashTable3Test {

	@Test
	public void test() {
		HashTable3<String, String> hashTable3 = new HashTable3<>(10);
		
		hashTable3.insert("username", "���ػ�");
		hashTable3.insert("age", "21");
		hashTable3.insert("classes", "�������");
		hashTable3.insert("sex", "��");
		hashTable3.insert("username", "���ػ�");
		hashTable3.insert("11111", "���ػ�");
		hashTable3.insert("22222", "���ػ�");
		
		System.out.println(hashTable3.find("username"));
		System.out.println(hashTable3.find("11111"));
		System.out.println(hashTable3.find("22222"));
		
		System.err.println(hashTable3.delete("sex"));
		System.out.println(hashTable3.find("sex"));
	}

}
