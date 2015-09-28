package com.shma.chapter05;

public class TestMain {

	public static void main(String[] args) {
		
		RequestQueue queue = new RequestQueue();
		
		new ClientThread(queue, "client01").start();
		new ClientThread(queue, "client02").start();
		new ClientThread(queue, "client03").start();
		
		new ServerThread(queue, "server01").start();
		new ServerThread(queue, "server02").start();
		new ServerThread(queue, "server03").start();
		new ServerThread(queue, "server04").start();
		new ServerThread(queue, "server05").start();
		new ServerThread(queue, "server06").start();
		
	}
}
