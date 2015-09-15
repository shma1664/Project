package com.shma.chapter03.connector.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * HTTPÁ¬½ÓÆ÷
 * @author admin
 *
 */
public class HttpConnector implements Runnable {

	private boolean shutdown = false;
	
	private String scheme = "http";

	public String getScheme() {
		return scheme;
	}

	@Override
	public void run() {
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket(8989, 1, InetAddress.getByName("127.0.0.1"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		while(!shutdown) {
			 Socket socket = null;
			 try {
				socket = ss.accept();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
				
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
