package com.shma.chapter03;

public class TestMain {

	public static void main(String[] args) {
		Gate gate = new Gate();
		new UserThread(gate, "AA", "AAAAAAAA").start();
		new UserThread(gate, "BB", "BBBBBBBB").start();
		new UserThread(gate, "CC", "CCCCCCCC").start();
		new UserThread(gate, "DD", "DDDDDDDD").start();
		new UserThread(gate, "EE", "EEEEEEEEEE").start();
		new UserThread(gate, "FF", "FFFFFFFF").start();
		new UserThread(gate, "GG", "GGGGGGGG").start();
		new UserThread(gate, "HH", "HHHHHHHHHH").start();
		new UserThread(gate, "II", "IIIIIIII").start();
		new UserThread(gate, "JJ", "JJJJJJJJJJ").start();
	}
}
