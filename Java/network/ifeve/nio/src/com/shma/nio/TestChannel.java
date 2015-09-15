package com.shma.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannel {

	public static void main(String[] args) {
		RandomAccessFile aFile = null;
		try {
			aFile = new RandomAccessFile("D:/executeLog.log", "rw");
			FileChannel inChannel = aFile.getChannel();
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			int bytesRead = inChannel.read(buf);
			
			System.out.println("Read " + bytesRead);
			buf.flip();
			
			if(!buf.hasRemaining()){
				buf.clear();
				inChannel.read(buf);
			}


			while(buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
	
			buf.clear();
			bytesRead = inChannel.read(buf);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				aFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
