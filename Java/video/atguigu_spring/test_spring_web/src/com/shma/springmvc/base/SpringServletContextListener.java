package com.shma.springmvc.base;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		String path = servletContext.getInitParameter("contextConfigLocation");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		
		servletContext.setAttribute("SPRING_CTX", ctx);
	}

}
