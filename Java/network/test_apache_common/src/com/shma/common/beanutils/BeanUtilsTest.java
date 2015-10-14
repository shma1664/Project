package com.shma.common.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

/**
 * JavaBean操作工具类
 * @author admin
 *
 */
public class BeanUtilsTest {

	@Test
	public void testProperty01() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		Class<?> clazz = Class.forName("com.shma.common.beanutils.Person");
		Person person = (Person) clazz.newInstance();

		BeanUtils.setProperty(person, "name", "张三");
		
		//使用默认的日期格式化
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(person, "date", "1989-12-07");
		
		System.out.println(person);

	}
	
	public Person testProperty02() throws IllegalAccessException, InvocationTargetException {
		Person person = new Person();
		
		BeanUtils.setProperty(person, "id", 1);
		BeanUtils.setProperty(person, "name", "李四");
		
		ConvertUtils.register(new Converter() {
			
			@Override
			public Date convert(Class clazz, Object value) {
				if(value == null)
					return null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = null;
				try {
					date = sdf.parse(String.valueOf(value));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				return date;
			}
			
		}, Date.class);
		
		BeanUtils.setProperty(person, "date", "2015-10-13 11:53:54");
		
		System.out.println(person);
		
		return person;
	}
	
	@Test
	public void testClone() throws Exception {
		Person person = testProperty02();
		
		Person newPerson = (Person) BeanUtils.cloneBean(person);
		
		System.out.println(newPerson);
		
		System.out.println(newPerson == person);
		
	}
	
	@Test
	public void testMap2Bean() throws Exception {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("id", 2);
		dataMap.put("name", "王五");
		dataMap.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		// map转bean
		Person person = new Person();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(person, dataMap);
		System.out.println(person);
		
		// bean转map
		Person person2 = testProperty02();
		Map<String, String> newDataMap = BeanUtils.describe(person2);
		System.out.println(newDataMap);
		
	}

}
