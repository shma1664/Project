package com.shma.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TestChatClient implements Runnable {

	private Selector selector;

	private String host = "127.0.0.1";
	private int port = 9999;
	
	private Charset charset = Charset.forName("UTF-8");
	private SocketChannel sChannel;
	
	private boolean isRunning = true;
	
	public void init() throws IOException {
		selector = Selector.open();
		sChannel = SocketChannel.open(new InetSocketAddress(host, port));
		sChannel.configureBlocking(false);
		sChannel.register(selector, SelectionKey.OP_READ);
	}
	
	@Override
	public void run() {
		
		try {
			init();
			execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void execute() throws IOException {
		ReadKeyBoard readKeyBoard = new ReadKeyBoard();
		readKeyBoard.start();
		
		while(isRunning) {
			String line = readIn();
			if(line != null && !"".equals(line)) {
				
				System.out.println(line);
				
				if(line.equals("bye-bye")) {
					isRunning = false;
					readKeyBoard.setRunning(false);
					
					sChannel.close();
					sChannel.socket().close();
				}
			}
		}
	}
	
	private String readIn() throws IOException {
		
		
		StringBuffer sb = new StringBuffer();
		ByteBuffer buffer = ByteBuffer.allocate(128);
		while(true) {
			int len = sChannel.read(buffer);
			
			if(len <= 0) {
				break;
			}
			
			buffer.flip();
			sb.append(new String(buffer.array(), 0, len));
			
			buffer.clear();
		}
		
		String line = sb.toString();
		sb = null;
		
		return line;
	}
	
	class ReadKeyBoard extends Thread {

		private boolean isRunning = true;
		
		@Override
		public void run() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			while (isRunning) {
				try {
					String str = reader.readLine();
					sChannel.write(charset.encode(str));

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		public void setRunning(boolean isRunning) {
			this.isRunning = isRunning;
		}

	}
	
	public static void main(String[] args) {
		new Thread(new TestChatClient()).start();
	}

}
