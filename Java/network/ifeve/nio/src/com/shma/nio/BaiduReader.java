package com.shma.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class BaiduReader {

	private Charset charset = Charset.forName("GBK");

	private SocketChannel socketChannel;

	public void readContent() {
		InetSocketAddress address = new InetSocketAddress("www.baidu.com", 80);

		try {
			socketChannel = SocketChannel.open(address);

			socketChannel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));

			ByteBuffer buffer = ByteBuffer.allocate(1024);

			while ((socketChannel.read(buffer)) != -1) {
				buffer.flip();
				System.out.println(charset.decode(buffer));
				buffer.clear();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socketChannel != null) {
				try {
					socketChannel.close();
				} catch (IOException e) {
				}
			}
		}

	}
	
	public static void main(String[] args) {
		new BaiduReader().readContent();
	}
}
