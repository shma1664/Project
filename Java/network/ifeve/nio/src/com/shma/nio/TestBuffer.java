package com.shma.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestBuffer {

	public static void main(String[] args) {
		
		
		ByteBuffer buffer01 = ByteBuffer.allocate(10);
		ByteBuffer buffer02 = ByteBuffer.allocate(16);
		
		buffer01.put((byte)2);
		buffer01.put((byte)2);
		buffer01.put((byte)3);
		buffer01.put((byte)1);
		
		buffer02.put((byte)1);
		buffer02.put((byte)2);
		buffer02.put((byte)3);
		
		System.out.println(buffer01.toString());
		System.out.println(buffer02.toString());
		
		System.out.println(buffer01.equals(buffer01)); //true
		
		System.out.println(buffer01.compareTo(buffer02));
		
//		RandomAccessFile aFile = null;
//		try {
//			aFile = new RandomAccessFile("D:/executeLog.log", "rw");
//			FileChannel inChannel = aFile.getChannel();
//			
//			//创建一个1024字节的缓存区
//			ByteBuffer buf = ByteBuffer.allocate(1024);
//			int bytesRead = inChannel.read(buf);
//			
//			System.out.println("Read " + bytesRead);
//			
//			while(bytesRead != -1) {
//				
//				//将Buffer从写模式切换到读模式,
//				//调用flip()方法会将position设回0，并将limit设置成之前position的值
//				buf.flip();
//				
//				while(buf.hasRemaining()) {
//					System.out.print((char) buf.get());
//				}
//				
//				//清空整个缓冲区
//				buf.clear();
//				bytesRead = inChannel.read(buf);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				aFile.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}
