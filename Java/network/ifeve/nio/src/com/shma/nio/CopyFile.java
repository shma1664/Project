package com.shma.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {

	public static void main(String[] args) {
		String inputFile = "D:/executeLog.log";
		String outputFile = "D:/executeLog_bak.log";
		
		File inFile = new File(inputFile);
		File outFile = new File(outputFile);
		
		try {
			if(!outFile.exists()) {
				outFile.createNewFile();
			}
			
			FileInputStream fin = new FileInputStream(inFile);
			FileOutputStream fout = new FileOutputStream(outFile);
			
			FileChannel inChannel = fin.getChannel();
			FileChannel outChannel = fout.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int len = inChannel.read(buffer);
			while(len != -1) {
				
				buffer.flip();
				while(buffer.hasRemaining()) {
					outChannel.write(buffer);
				}
				
				
				buffer.clear();
				
				len = inChannel.read(buffer);
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
