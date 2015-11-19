package com.shma.common.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestFileUtils {

	public static void main(String[] args) throws IOException {
		
		FileUtils.copyFile(new File("D:/opt/log/customelog/statisLog.log"), new File("D:/1.txt"));
		
		List<String> data = FileUtils.readLines(new File("D:/opt/log/customelog/statisLog.log"));
		System.out.println(data);
	}
}
