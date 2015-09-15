package com.shma.chapter02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

import com.shma.chapter02.part01.HttpServer01;

/**
 * 自定义响应类
 * @author admin
 *
 */
public class Response implements ServletResponse {

	private static final int BUFFER_SIZE = 1024;
	
	private OutputStream outputStream;
	
	private Request request;
	
	private PrintWriter writer;
	
	public Response(OutputStream outputStream) {
		super();
		this.outputStream = outputStream;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	/**
	 * 访问静态资源
	 * @throws IOException 
	 */
	public void sendStaticResource() throws IOException {
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		File file = new File(Constants.WEB_ROOT, request.getUri());
		FileInputStream fis = null;
		if(file.exists()) {
			try {
				fis = new FileInputStream(file);
				int index = fis.read(buffer, 0, BUFFER_SIZE);
				while(index != -1) {
					outputStream.write(buffer, 0, index);
					index = fis.read(buffer, 0, BUFFER_SIZE);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				outputStream.write(errorMsg().getBytes());
			} finally {
				if(fis != null) {
					fis.close();
					fis = null;
				}
			}
		 } else {
			 outputStream.write(errorMsg().getBytes());
		 }
	}
	
	private String errorMsg() {
		String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
		        "Content-Type: text/html\r\n" +
		        "Content-Length: 23\r\n" +
		        "\r\n" +
		        "<h1>File Not Found</h1>";
		
		return errorMessage;
	}

	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		writer = new PrintWriter(outputStream, true);
		return writer;
	}

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBufferSize(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterEncoding(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContentLength(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContentType(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocale(Locale locale) {
		// TODO Auto-generated method stub

	}

}
