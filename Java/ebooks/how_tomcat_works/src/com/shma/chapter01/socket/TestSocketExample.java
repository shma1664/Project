package com.shma.chapter01.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ͨ��Socket(�ͻ����׽���)������http���󲢻�ȡ����
 * @author admin
 *
 */
public class TestSocketExample {

	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			socket = new Socket("www.guagua.cn", 80);
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			pw.println("GET / HTTP/1.1");
			pw.println("Host: www.guagua.cn:80");
			pw.println("Connection: close");
			pw.println();
			pw.flush();
			//��ȡ����
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line).append("\r\n");
			}
			Thread.sleep(1000);
			
			System.out.println(sb.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(br != null) {
					br.close();
					br = null;
				}
				
				if(pw != null) {
					pw.close();
					pw = null;
				}
				
				if(socket != null) {
					socket.close();
					socket = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
