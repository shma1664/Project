package com.shma.hash;


import org.junit.Test;

public class HashTable2Test {

	@Test
	public void test() {
		HashTable2<String, String> hashTable2 = new HashTable2<>(10);
		
		System.out.println("insert abc : " + hashTable2.insert("abc", "abc"));
		System.out.println("insert fsd : " + hashTable2.insert("fsd", "fsd"));
		System.out.println("insert wer : " + hashTable2.insert("wer", "wer"));
		System.out.println("insert rewr : " + hashTable2.insert("rewr", "rewr"));
		System.out.println("insert wer : " + hashTable2.insert("wer", "ewr"));
		System.out.println("insert dad : " + hashTable2.insert("dad", "dad"));
		System.out.println("insert dad : " + hashTable2.insert("ewqe", "dad"));
		System.out.println("insert dad : " + hashTable2.insert("qwewq", "dad"));
		System.out.println("insert dad : " + hashTable2.insert("213", "dad"));
		System.out.println("insert dad : " + hashTable2.insert("213", "dad"));
		System.out.println("insert dad : " + hashTable2.insert("wqeqw", "dad"));
		System.out.println("insert dad : " + hashTable2.insert("ewqe", "dad"));
		System.out.println("insert dad : " + hashTable2.insert("asw", "dad"));
		hashTable2.print();
		System.err.println("del 213 : " + hashTable2.delete("213"));
		hashTable2.print();
		System.out.println("insert gdfg : " + hashTable2.insert("gdfg", "dad"));
		hashTable2.print();
		System.out.println("find fsd : " + hashTable2.find("fsd11111"));
		System.err.println("del null : " + hashTable2.delete("123213"));
	}

}
