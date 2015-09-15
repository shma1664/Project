package com.shma.chapter01.simpleweb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Http服务器类
 * @author admin
 *
 */
public class HttpServer {
	
	/**
	 * 定义静态资源访问路径
	 */
	public static final String WEB_ROOT = System.getProperty("user.dir") + 
												File.separator + "WebRoot";
	
	/**
	 * 关闭服务命令
	 */
	private static final String SHUTDOWN_COMMAND = "/shutdown";
	
	private ServerSocket ss = null; 
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		new HttpServer().await();
	}
	
	public void await() {
		Socket socket = null;
		try {
			ss = new ServerSocket(9999, 10, InetAddress.getByName("127.0.0.1"));
			
			while(!shutdown) {
				
				InputStream input = null;
			    OutputStream output = null;
				try {
					socket = ss.accept();
					input = socket.getInputStream();
					output = socket.getOutputStream();
					
					Request request = new Request(input);
					Response response = new Response(output);
					request.parse();
					response.setRequest(request);
					response.sendStaticResource();
					
					shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
				} finally {
					if(socket != null) {
						socket.close();
						socket = null;
					}
					
				}
				
				
			} 
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			try {
				closeServerSocket();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeServerSocket() throws IOException {
		if(ss != null) {
			ss.close();
			ss = null;
		}
	}
}
