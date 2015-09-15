package com.shma.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestScatterGather {
	
public void testScatter() throws IOException {
	ByteBuffer headerBuffer = ByteBuffer.allocate(108);
	ByteBuffer bodyBuffer = ByteBuffer.allocate(1024);
	
	ByteBuffer[] arrBuffers = {headerBuffer, bodyBuffer};
	
	FileChannel channel = new FileInputStream("D:/data.txt").getChannel();
	channel.read(arrBuffers);
}

public void testGather() throws IOException {
	ByteBuffer headerBuffer = ByteBuffer.allocate(108);
	ByteBuffer bodyBuffer = ByteBuffer.allocate(1024);
	
	ByteBuffer[] arrBuffers = {headerBuffer, bodyBuffer};
	
	FileChannel channel = new FileInputStream("D:/data.txt").getChannel();
	channel.write(arrBuffers);
} 
}
