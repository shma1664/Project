package com.shma.chapter03.resource;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

public class FileSourceExample {

	@Test
	public void testFileSystemResource() throws IOException {
		
		String path = "E:/git/Project/Java/ebooks/spring3.x_practice/src/com/shma/chapter03/resource/file.txt";
		
		//通过绝对路径加载文件
		Resource fileResource = new FileSystemResource(path);
		EncodedResource encodedResource = new EncodedResource(fileResource, "UTF-8");
		String content = FileCopyUtils.copyToString(encodedResource.getReader());
		System.out.println(content);
		print(fileResource);
	}
	
	@Test
	public void classPathResource() {
		String path = "com/shma/chapter03/resource/file.txt";
		Resource classPathResource = new ClassPathResource(path);
		System.out.println(classPathResource.getFilename());
		print(classPathResource);
	}
	
	private void print(Resource resource) {
		BufferedInputStream bufferedInputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(resource.getInputStream());
			byte bytes[] = new byte[1024];
			int len = 0;   
	        int temp=0; //所有读取的内容都使用temp接收   
			while((temp = bufferedInputStream.read()) != -1) {
				bytes[len] = (byte)temp;
				len++;
			}
			System.out.println(new String(bytes));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedInputStream.close();
				bufferedInputStream = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
