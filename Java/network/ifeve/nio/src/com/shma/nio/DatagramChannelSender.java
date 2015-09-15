package com.shma.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author dzh
 *
 */
public class DatagramChannelSender {
	
	public static void main(String[] args) {
		try {
			send();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void send() throws IOException{
		DatagramChannel channel =DatagramChannel.open();
		ByteBuffer buffer =ByteBuffer.wrap("下雨的夜晚很安静".getBytes("utf-8"));
		int i=0;
		while(i<100) {
			i++;
			channel.send(buffer, new InetSocketAddress("localhost",10022));
		}
		
		
		channel.close();
	}
	
}