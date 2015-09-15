package com.shma.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAppMain {

	public static void main(String[] args) {
		
		String path = "/config/spring-application.xml";
		System.out.println(path);
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		RedisCache redisCache = context.getBean(RedisCache.class);
		
		redisCache.set("22211122", "我是中国人");
		
		System.out.println(redisCache.get("22211122"));
		
		System.out.println(redisCache.del("22211122"));
	}
}
