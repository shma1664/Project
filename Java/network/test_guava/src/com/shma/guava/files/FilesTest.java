package com.shma.guava.files;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

/**
 * 文件流处理
 * @author admin
 *
 */
public class FilesTest {

	/**
	 * 演示向文件中写入字节流
	 */
	@Test
	public void testWrite() {
		String content = "我是中国人\r\n我深爱着我的祖国";
		String descFilePath = "D:/2.txt";
		File descFile = new File(descFilePath);
		try {
			Files.write(content.getBytes(), descFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 一次性读取文件所有内容，小个文件
	 */
	@Test
	public void testReadLines() {
		String descFilePath = "D:/2.txt";
		File descFile = new File(descFilePath);
		try {
			List<String> lines = Files.readLines(descFile, Charsets.UTF_8);
			System.out.println(lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 分行读取
	 * @throws IOException 
	 */
	@Test
	public void testReadRowLines() throws IOException {
		String descFilePath = "D:/2.txt";
		File descFile = new File(descFilePath);
		CounterLine counterLine = new CounterLine();
		int counter = Files.readLines(descFile, Charsets.UTF_8, counterLine);
		System.out.println(counter);
		System.out.println(counterLine.getResult());
		
		List<String> lines = Files.readLines(descFile, Charsets.UTF_8, new StatusLine());
		System.out.println(lines);
	}
	
	class CounterLine implements LineProcessor<Integer> {

		private final AtomicInteger rowNum = new AtomicInteger();
		
		@Override
		public boolean processLine(String line) throws IOException {
			rowNum.incrementAndGet();
			return true;
		}

		@Override
		public Integer getResult() {
			return rowNum.get();
		}
		
	}
	
	class StatusLine implements LineProcessor<List<String>> {

		private final List<String> lines = Lists.newArrayList();
		
		@Override
		public boolean processLine(String line) throws IOException {
			lines.add(line);
			return true;
		}

		@Override
		public List<String> getResult() {
			return lines;
		}
		
	}
	
	/**
	 * 复制
	 * @throws IOException
	 */
	@Test
	public void testCopy() throws IOException {
		String sourceFilePath = "D:/2.txt";
		File sourceFile = new File(sourceFilePath);
		
		String targetFilePath = "D:/3.txt";
		File targetFile = new File(targetFilePath);
		
		Files.copy(sourceFile, targetFile);
	}
	
	/**
	 * 比较两个文件的内容是否完全一致
	 * @throws IOException 
	 */
	@Test
	public void testEquals() throws IOException {
		String sourceFilePath = "D:/2.txt";
		File sourceFile = new File(sourceFilePath);
		
		String targetFilePath = "D:/3.txt";
		File targetFile = new File(targetFilePath);
		
		System.out.println(Files.equal(sourceFile, targetFile)); //true
		
		System.out.println(Files.getNameWithoutExtension(targetFilePath)); //3
		
		Files.move(sourceFile, new File("D:/4.txt"));
	}
}
