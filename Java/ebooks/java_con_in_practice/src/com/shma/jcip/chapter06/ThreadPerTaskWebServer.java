package com.shma.jcip.chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPerTaskWebServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(80);
		while(true) {
			final Socket socket = ss.accept();
			Runnable task = new Runnable() {
				
				@Override
				public void run() {
					handleRequest(socket);
				}
			};
			
			new Thread(task).start();
			
		}
	}
	
	private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
