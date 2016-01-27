package com.shma.concurrency.chapter04.recipe11;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.Callable;

import com.google.common.io.Files;

public class FileCountLine implements Callable<Integer> {

	private File file;

	public FileCountLine(File file) {
		super();
		this.file = file;
	}
	
	public int getFileLineCount() {
		try {
			List<String> lines = Files.readLines(file, Charset.defaultCharset());
			if(lines != null) {
				return lines.size();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Integer call() throws Exception {
		int counter = getFileLineCount();
		System.err.printf("%s 文件总行数为：%d\n", file.getAbsoluteFile(), counter);
		
		return counter;
	}
	
	
}
