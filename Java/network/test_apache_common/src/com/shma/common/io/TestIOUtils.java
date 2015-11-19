package com.shma.common.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class TestIOUtils {

	@Test
	public void test() throws MalformedURLException, IOException {
		InputStream in = new URL( "http://www.baidu.com" ).openStream(); 
		List<String> data = IOUtils.readLines(in);
		System.out.println(data);
	}
}
