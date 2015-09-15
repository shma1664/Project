package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.redis.RedisCache;

public class TestRedis {

	private ApplicationContext context;
	
	@Before
	public void init() throws Exception {
		String path = "/config/spring-application.xml";
		System.out.println(path);
		context = new ClassPathXmlApplicationContext(path);		
	}

	@Test
	public void test() {
		RedisCache redisCache = context.getBean(RedisCache.class);
		
		redisCache.set("haha_123", "我是中国人");
		
		System.out.println(redisCache.get("haha_123"));
		
		System.out.println(redisCache.del("haha_123"));
		
	}

}
