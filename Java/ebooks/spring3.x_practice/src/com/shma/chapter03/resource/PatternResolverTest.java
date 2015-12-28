package com.shma.chapter03.resource;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

public class PatternResolverTest {

	@Test
	public void testResourcePatternResolver() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath*:com/shma/**/*.txt");
		for(Resource resource : resources) {
			System.out.println(resource.getFile().exists());
		}
	}
	
	@Test
	public void test() {

		ResourcePatternUtils.getResourcePatternResolver(new ResourceLoader() {
			
			@Override
			public Resource getResource(String paramString) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ClassLoader getClassLoader() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
}
