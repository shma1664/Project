package com.shma.chapter02.part02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestFacade implements ServletRequest {

	private ServletRequest servletRequest;
	
	public RequestFacade(ServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	@Override
	public Object getAttribute(String s) {
		// TODO Auto-generated method stub
		return servletRequest.getAttribute(s);
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return servletRequest.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return servletRequest.getCharacterEncoding();
	}

	@Override
	public void setCharacterEncoding(String s)
			throws UnsupportedEncodingException {
		servletRequest.setCharacterEncoding(s);
	}

	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return servletRequest.getContentLength();
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return servletRequest.getContentType();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return servletRequest.getInputStream();
	}

	@Override
	public String getParameter(String s) {
		// TODO Auto-generated method stub
		return servletRequest.getParameter(s);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return servletRequest.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String s) {
		// TODO Auto-generated method stub
		return servletRequest.getParameterValues(s);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return servletRequest.getParameterMap();
	}

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return servletRequest.getProtocol();
	}

	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return servletRequest.getScheme();
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return servletRequest.getServerName();
	}

	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return servletRequest.getServerPort();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return servletRequest.getReader();
	}

	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return servletRequest.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return servletRequest.getRemoteHost();
	}

	@Override
	public void setAttribute(String s, Object obj) {
		// TODO Auto-generated method stub
		servletRequest.setAttribute(s, obj);
	}

	@Override
	public void removeAttribute(String s) {
		// TODO Auto-generated method stub
		servletRequest.removeAttribute(s);
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return servletRequest.getLocale();
	}

	@Override
	public Enumeration<Locale> getLocales() {
		// TODO Auto-generated method stub
		return servletRequest.getLocales();
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return servletRequest.isSecure();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String s) {
		// TODO Auto-generated method stub
		return servletRequest.getRequestDispatcher(s);
	}

	@Override
	public String getRealPath(String s) {
		// TODO Auto-generated method stub
		return servletRequest.getRealPath(s);
	}

	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return servletRequest.getRemotePort();
	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return servletRequest.getLocalName();
	}

	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return servletRequest.getLocalAddr();
	}

	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return servletRequest.getLocalPort();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return servletRequest.getServletContext();
	}

	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		// TODO Auto-generated method stub
		return servletRequest.startAsync();
	}

	@Override
	public AsyncContext startAsync(ServletRequest servletrequest,
			ServletResponse servletresponse) throws IllegalStateException {
		// TODO Auto-generated method stub
		return servletRequest.startAsync(servletrequest, servletresponse);
	}

	@Override
	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return servletRequest.isAsyncStarted();
	}

	@Override
	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return servletRequest.isAsyncStarted();
	}

	@Override
	public AsyncContext getAsyncContext() {
		// TODO Auto-generated method stub
		return servletRequest.getAsyncContext();
	}

	@Override
	public DispatcherType getDispatcherType() {
		// TODO Auto-generated method stub
		return servletRequest.getDispatcherType();
	}

}
