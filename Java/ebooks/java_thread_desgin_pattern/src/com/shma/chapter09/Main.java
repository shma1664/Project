package com.shma.chapter09;

public class Main {

	public static void main(String[] args) {
		Host host = new Host();
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
		host.request(40, 'D');
		host.request(50, 'E');
	}
}
