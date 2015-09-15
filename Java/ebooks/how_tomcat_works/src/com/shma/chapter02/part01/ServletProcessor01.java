package com.shma.chapter02.part01;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.shma.chapter02.Request;
import com.shma.chapter02.Response;

/**
 * servlet请求处理类
 * @author admin
 *
 */
public class ServletProcessor01 {

	private static String BASE_PACKET_PATH = "E:/apache-tomcat-7.0.55/webapps/how_tomcat_works/WEB-INF/classes";
	
	public void process(Request request, Response response) {
		String servletName = "com.shma.chapter02." + request.getUri().split("\\/")[2];
		URLStreamHandler handler = null;
		URLClassLoader classLoader = null;
		URL[] urls = new URL[1];
		File classPath = new File(BASE_PACKET_PATH);
		String repository;
		try {
			repository = new URL("file", null, classPath.getCanonicalPath() + File.separator).toString();
			urls[0] = new URL(null, repository, handler);
			classLoader = new URLClassLoader(urls);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Servlet servlet = null;
		
		try {
			Class<?> classz = classLoader.loadClass(servletName);
			servlet = (Servlet)classz.newInstance();
			servlet.service(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
