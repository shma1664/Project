package com.shma.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TestSelector {

	public static void main(String[] args) throws IOException {
		
		SocketChannel socketChannel = SocketChannel.open();
		Selector selector = Selector.open();
		socketChannel.configureBlocking(false);
		socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		
		while(true) {
			int keyCount = selector.select();
			
			if(keyCount == 0) {
				continue;
			}
			
			Set<SelectionKey> selectionKeys = selector.keys();
			
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while(iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				
				if(selectionKey.isAcceptable()) {
					
				} else if(selectionKey.isConnectable()) {
					
				} else if(selectionKey.isReadable()) {
					
				} else if(selectionKey.isWritable()) {
					
				}
				
				iterator.remove();
				
			}
			
		}
	}
}
