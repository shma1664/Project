package com.shma.chapter01.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocketClientExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			Socket socket = new Socket("127.0.0.1", 9998);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = br.readLine();
			System.out.println(line);
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
