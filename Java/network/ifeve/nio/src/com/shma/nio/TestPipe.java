package com.shma.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

public class TestPipe {

	public static void main(String[] args) throws IOException {
		Pipe pipe = Pipe.open();
		
		SinkChannel sinkChannel = pipe.sink();
		
		String newData = "我是中国人";
		
		ByteBuffer buffer = ByteBuffer.wrap(newData.getBytes());
		buffer.flip();
		
		while(buffer.hasRemaining()) {
			sinkChannel.write(buffer);
		}
		
		SourceChannel sourceChannel = pipe.source();
		
		ByteBuffer buffer2 = ByteBuffer.allocate(1024);
		
		StringBuffer sb = new StringBuffer();
		
		sourceChannel.read(buffer2);
		buffer2.flip();
		sb.append(buffer2);
		buffer2.clear();
		
		System.out.println(sb);
	}
}
