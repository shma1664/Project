package com.shma.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TestSocketChanelToFileChanel {

	public static void main(String[] args) throws IOException {
		
		Selector selector = Selector.open();
		
		SocketChannel sChannel = SocketChannel.open();
		sChannel.connect(new InetSocketAddress("www.baidu.com", 80));
		sChannel.register(selector, SelectionKey.OP_READ);
		sChannel.configureBlocking(false);
		
		int readyChannels = selector.select();
        Set selectedKeys = selector.selectedKeys();  //可以通过这个方法，知道可用通道的集合
        Iterator keyIterator = selectedKeys.iterator();
	}
}
