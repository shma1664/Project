package com.shma.jcip.chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {

	private static final Executor exec = Executors.newFixedThreadPool(100);
	
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(80);
		while(true) {
			final Socket socket = ss.accept();
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					handleRequest(socket);
				}
			};
			
			exec.execute(runnable);
		}
	}
	
	private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
