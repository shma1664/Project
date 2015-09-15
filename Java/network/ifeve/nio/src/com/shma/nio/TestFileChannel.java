package com.shma.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannel {

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
			
			long position = 0;
			long count = inChannel.size();
			
//			outChannel.transferFrom(inChannel, position, count);
			
			inChannel.transferTo(position, count, outChannel);
			inChannel.force(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
