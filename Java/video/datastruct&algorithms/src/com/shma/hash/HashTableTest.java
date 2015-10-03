package com.shma.hash;

import org.junit.Test;

public class HashTableTest {

	@Test
	public void test() {
		HashTable<String, String> hashTable = new HashTable<>(10);
		hashTable.insert("username", "马韶华");
		hashTable.insert("age", "21");
		hashTable.insert("classes", "三年二班");
		hashTable.insert("sex", "男");
		hashTable.insert("username", "马韶华");
		hashTable.insert("11111", "马韶华");
		hashTable.insert("22222", "马韶华");
		
		System.out.println(hashTable.find("username"));
		System.out.println(hashTable.find("classes"));
		System.out.println(hashTable.find("age"));
		System.out.println(hashTable.find("sex"));
		System.out.println(hashTable.find("22222"));
		
		System.out.println(hashTable.del("username"));
		System.err.println(hashTable.find("username"));
		
	}

}
