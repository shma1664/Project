package com.shma.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class TestChatServer implements Runnable {

	private Selector selector;
	
	private static final int PORT = 9999;
	
	private static final Charset charset = Charset.forName("UTF-8");
	
	private boolean isRunning = true;
	
	private ServerSocketChannel ssChannel = null;
	
	private FileChannel fileChannel = null;
	
	public void init() throws IOException {
	
		selector = Selector.open();
		ssChannel = ServerSocketChannel.open();
		ssChannel.configureBlocking(false);
		ssChannel.socket().bind(new InetSocketAddress(PORT));
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		File file = new File("d:/data.txt");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		fileChannel = new FileInputStream(file).getChannel();
		
		System.out.println("Server is starting, listening port : " + PORT);
		
	}
	
	public void execute() throws IOException {
		
		while(isRunning) {
			int readyChannels = selector.select();
			if(readyChannels <= 0) 
				continue;
			
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while(iterator.hasNext()) {
				SelectionKey key = iterator.next();
				
				iterator.remove();
				
				if(!key.isValid()) {
					continue;
				}

				if(key.isAcceptable()) {
					getConnection(key);
				} else if(key.isConnectable()) {
					
				} else if(key.isReadable()) {
					readMsg(key);
				} else if(key.isWritable()) {
//					writeMsg(key);
				}
			}
			
		}
	}
	
	private void writeMsg(SelectionKey key) throws IOException {
		SocketChannel sc = (SocketChannel) key.channel();
		String str = (String) key.attachment();

		sc.write(charset.encode(str));
		key.interestOps(SelectionKey.OP_READ);
	}

	private void readMsg(SelectionKey key) throws IOException {
		SocketChannel sChannel = (SocketChannel) key.channel();
		
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
		
		if(line != null && !"".equals(line)) {
			if(line.toLowerCase().equals("quit")) {
				sChannel.write(charset.encode("bye-bye"));
				key.cancel();
				sChannel.close();
				sChannel.socket().close();
			} else {
				String newLine = sChannel.socket().getRemoteSocketAddress() + " : " + line;
				Set<SelectionKey> keys = key.selector().keys();
				for(SelectionKey selectionKey : keys) {
					
					SelectableChannel channel = selectionKey.channel();
					
					if(channel instanceof SocketChannel) {
						SocketChannel socketChannel = (SocketChannel) channel;
						socketChannel.write(charset.encode(newLine));
					} else {
						ServerSocketChannel socketChannel = (ServerSocketChannel) channel;
					}
					
					
				}
				key.interestOps(SelectionKey.OP_READ);
			}
		}
		
	}

	private void getConnection(SelectionKey key) throws IOException {
		ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
		SocketChannel sChannel = ssChannel.accept();
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
	
	public static void main(String[] args) {
		new Thread(new TestChatServer()).start();
	}

}
