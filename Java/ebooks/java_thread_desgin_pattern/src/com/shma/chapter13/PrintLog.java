package com.shma.chapter13;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 打印日志基础类
 * @author admin
 *
 */
public class PrintLog {

	private PrintWriter pw;
	
	private static final String PATH = "D:/opt/";
	
	public PrintLog(String fileName) {
		
		File file = new File(PATH + fileName);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			pw = new PrintWriter(file);
			pw.println("------ start of log ------");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void write(String data) {
		pw.println(data);
		pw.flush();
	}
	
	public void close() {
		
		if(pw != null) {
			pw.println("------ end of log ------");
			pw.flush();
			pw.close();
			pw = null;
		}
	}
}
