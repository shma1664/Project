package com.shma.chapter01.socket;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ServerSocket：服务器套接字
 * @author admin
 *
 */
public class TestServerSocketExample {

	public static void main(String[] args) {
		
		ServerSocket ss = null;
		BufferedWriter bw = null;
		Socket socket = null;
		try {
			ss = new ServerSocket(9998, 1, InetAddress.getByName("127.0.0.1"));
			while((socket = ss.accept()) != null) {
				bw = new BufferedWriter(new PrintWriter(socket.getOutputStream()));
				bw.write("Hello:马韶华");
				bw.flush();
				bw.close();
				socket.close();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		
			try {
				
				if(bw == null) {
					bw.close();
					bw = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
