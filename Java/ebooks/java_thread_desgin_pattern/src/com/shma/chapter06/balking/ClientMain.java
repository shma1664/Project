package com.shma.chapter06.balking;

/**
 * Balkingģʽ
 * @author admin
 *
 */
public class ClientMain {

	public static void main(String[] args) {
		Data data = new Data("D:/test.txt");
		new ChangerThread("changedThread", data).start();
		new SaverThread("saveThread", data).start();
	}
}
