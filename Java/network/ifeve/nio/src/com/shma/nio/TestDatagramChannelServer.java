package com.shma.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class TestDatagramChannelServer {

	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		
		DatagramChannel channel = DatagramChannel.open();
		channel.configureBlocking(false);
		channel.socket().bind(new InetSocketAddress(9999));
		
		channel.register(selector, SelectionKey.OP_READ);
		
		while(true) {
			int index = selector.select();
			
			if(index == 0) {
				continue;
			}
			
			Set<SelectionKey> selectionKeys = selector.keys();
			
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			
			while(iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				
				if(selectionKey.isReadable()) {
					DatagramChannel selectableChannel = (DatagramChannel) selectionKey.channel();
					ByteBuffer buff = ByteBuffer.allocate(60);
					selectableChannel.configureBlocking(false);
					buff.clear();
		            selectableChannel.receive(buff);
		            buff.flip();
	            	String recStr = Charset.forName("utf-8").decode(buff).toString();
	        		System.out.println(recStr);
	        		
	        		selectionKey.interestOps(SelectionKey.OP_READ);
				}
			}
		}
	}
}
