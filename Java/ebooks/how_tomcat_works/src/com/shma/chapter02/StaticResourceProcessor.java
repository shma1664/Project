package com.shma.chapter02;

import java.io.IOException;

/**
 * 静态资源处理类
 * @author admin
 *
 */
public class StaticResourceProcessor {

	public void process(Request request, Response response) {
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
