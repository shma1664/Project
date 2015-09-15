package com.shma.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class TestDatagramChannelClient {

	public static void main(String[] args) throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		channel.configureBlocking(false);
		ByteBuffer buffer = ByteBuffer.allocate(60);
		buffer.put(Charset.forName("utf-8").encode("我是中国人"));
		buffer.flip();
		channel.send(buffer, new InetSocketAddress("127.0.0.1", 9999));
	}
}
