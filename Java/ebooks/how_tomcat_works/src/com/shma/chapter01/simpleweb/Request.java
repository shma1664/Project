package com.shma.chapter01.simpleweb;

import java.io.IOException;
import java.io.InputStream;

/**
 * 封装了请求信息
 * @author admin
 *
 */
public class Request {
	
	private InputStream inputStream;
	private String uri;
	
	public Request(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public void parse() throws IOException {
		StringBuffer sb = new StringBuffer();
		
		byte[] buffer = new byte[2048];
		int byteCount = inputStream.read(buffer);
		for(int i=0; i<byteCount; ++i) {
			sb.append((char)buffer[i]);
		}
		
		System.out.print(sb.toString());
		
		uri = getUri(sb.toString());
	}
	
	private String getUri(String reqString) {
		return reqString.split(" ")[1];
	}

	public String getUri() {
		return uri;
	}
}
