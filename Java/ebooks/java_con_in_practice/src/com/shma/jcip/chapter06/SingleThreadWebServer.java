package com.shma.jcip.chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(80);
		while(true) {
			Socket socket = ss.accept();
			handleRequest(socket);
		}
	}
	
	private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
