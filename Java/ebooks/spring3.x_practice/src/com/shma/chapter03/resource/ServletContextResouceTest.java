package com.shma.chapter03.resource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

public class ServletContextResouceTest extends HttpServlet {

	private static final long serialVersionUID = -1069563841231387565L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Resource resource = new ServletContextResource(getServletContext(), "/WEB-INF/user-servlet.xml");
		System.out.println(resource.getFile().exists());
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
