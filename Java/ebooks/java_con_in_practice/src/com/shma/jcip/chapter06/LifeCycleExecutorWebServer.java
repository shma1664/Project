package com.shma.jcip.chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.catalina.connector.Request;

public class LifeCycleExecutorWebServer {

	//创建一个可缓存的线程池
	private static final ExecutorService exec = Executors.newCachedThreadPool();

	public void start() throws IOException {
		ServerSocket ss = new ServerSocket(80);
		while(!exec.isShutdown()) {
			final Socket socket = ss.accept();
			exec.execute(new Runnable() {
				
				@Override
				public void run() {
					hanleRequest(socket);
				}
			});
		}
	}
	
	private void stop() {
		exec.shutdown();
	} 
	
	private void hanleRequest(Socket socket) {
		Request request = readRequest(socket);
		if(isShutdownRequest(request)) {
			stop();
		}
		
		dispatchRequest(request);
	}
	
	private Request readRequest(Socket s) {
        return null;
    }

    private void dispatchRequest(Request r) {
    }

    private boolean isShutdownRequest(Request r) {
        return false;
    }
}
