package com.shma.chapter02.part02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class ResponseFacade implements ServletResponse {

	private ServletResponse servletResponse;
	
	public ResponseFacade(ServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}
	
	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return servletResponse.getCharacterEncoding();
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return servletResponse.getContentType();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return servletResponse.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return servletResponse.getWriter();
	}

	@Override
	public void setCharacterEncoding(String s) {
		// TODO Auto-generated method stub
		servletResponse.setCharacterEncoding(s);
	}

	@Override
	public void setContentLength(int i) {
		// TODO Auto-generated method stub
		servletResponse.setContentLength(i);
	}

	@Override
	public void setContentType(String s) {
		// TODO Auto-generated method stub
		servletResponse.setContentType(s);
	}

	@Override
	public void setBufferSize(int i) {
		// TODO Auto-generated method stub
		servletResponse.setBufferSize(i);
	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return servletResponse.getBufferSize();
	}

	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		servletResponse.flushBuffer();
	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		servletResponse.resetBuffer();
	}

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return servletResponse.isCommitted();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		servletResponse.reset();
	}

	@Override
	public void setLocale(Locale locale) {
		// TODO Auto-generated method stub
		servletResponse.setLocale(locale);
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return servletResponse.getLocale();
	}

}
