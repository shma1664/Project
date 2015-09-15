package com.shma.chapter02.part02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.shma.chapter02.Request;
import com.shma.chapter02.Response;
import com.shma.chapter02.StaticResourceProcessor;

/**
 * 简单的模拟servlet容器类
 * @author admin
 *
 */
public class HttpServer02 {

	/**
	 * 关闭服务命令
	 */
	private static final String SHUTDOWN_COMMAND = "/shutdown";
	
	private ServerSocket ss = null; 
	private boolean shutdown = false;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new HttpServer02().await();
	}
	
	public void await() {
		
		Socket socket = null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		
		try {
			ss = new ServerSocket(9899, 10, InetAddress.getByName("127.0.0.1"));
			
			while(!shutdown) {
				try {
					socket = ss.accept();
					outputStream = socket.getOutputStream();
					inputStream = socket.getInputStream();
					
					Request request = new Request(inputStream);
					request.parse();
					
					Response response = new Response(outputStream);
					response.setRequest(request);
					
					if(request.getUri().startsWith("/servlet")) {
						
						ServletProcessor02 servletProcessor02 = new ServletProcessor02();
						servletProcessor02.process(request, response);
						
					} else {
						StaticResourceProcessor processor = new StaticResourceProcessor();
						processor.process(request, response);
					}
					
					//check if the previous URI is a shutdown command
			        shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
			        
				} finally {
					// Close the socket
					inputStream.close();
					outputStream.close();
			        socket.close();
				}

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(ss != null) {
					ss.close();
					ss = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
