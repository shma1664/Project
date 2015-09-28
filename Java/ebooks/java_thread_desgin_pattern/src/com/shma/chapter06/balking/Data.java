package com.shma.chapter06.balking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Data {

	private final String fileName;
	
	private String content;
	
	private volatile boolean isChanged = false;
	
	public Data(String fileName) {
		this.fileName = fileName;
	}
	
	public synchronized void changed(String content) {
		this.content = content;
		isChanged = true;
	}
	
	public void save() throws IOException {
		if(!isChanged) {
			return;
		}
		
		System.out.println(Thread.currentThread().getName() + " call doSave, content : " + content);
		
		doSave();
		isChanged = false;
	}
	
	private synchronized void doSave() throws IOException {
		File file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file, true);
		fw.write(content);
		fw.write("\r\n");
		fw.close();
	}
	
}
