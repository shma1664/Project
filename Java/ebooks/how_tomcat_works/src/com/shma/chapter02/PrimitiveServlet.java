package com.shma.chapter02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ԭʼ����servlet��ʵ��
 * @author admin
 *
 */
public class PrimitiveServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("desroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		System.out.println("from service");
		//��resp�л�ȡ���������socket�е�outpustream
		PrintWriter pw = resp.getWriter();
		pw.println("Hello, I am Shma, I am Chinese...");
		pw.print("I love my motherland");
		pw.flush();
	}

}
