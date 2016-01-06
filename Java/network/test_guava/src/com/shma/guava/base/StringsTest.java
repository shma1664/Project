package com.shma.guava.base;

import java.util.Map;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * 字符串处理
 * @author admin
 *
 */
public class StringsTest {

	/**
	 * 判断是否为空
	 */
	@Test
	public void testIsNullOrEmpty() {

		String name = "";

		System.out.println(Strings.isNullOrEmpty(name)); //true
		
		String name2 = null;
		System.out.println(Strings.isNullOrEmpty(name2)); //true
		
		String name3 = "shma";
		System.out.println(Strings.isNullOrEmpty(name3)); //false
	}

	/**
	 * 截取两个字符串的相同前缀
	 */
	@Test
	public void testCommonPrefix() {
		// 两个字符串相同的前缀或者后缀
		String aString = "hi,a.shma.hello";
		String bString = "hi,b.jjq.hello";

		System.out.println(Strings.commonPrefix(aString, bString)); //hi,
	}
	
	/**
	 * 截取两个字符串的相同后缀
	 */
	@Test
	public void testCommonSuffix() {
		// 两个字符串相同的前缀或者后缀
		String aString = "hi,a.shma.hello";
		String bString = "hi,b.jjq.hello";

		System.out.println(Strings.commonSuffix(aString, bString)); //.hello
	}
	
	/**
	 * 字符串补全
	 */
	@Test
	public void testPad() {
		int minLength = 5;
		
		//末尾以0补全
		String padEndResult = Strings.padEnd("123", minLength, '0');
		System.out.println(padEndResult); //12300
		
		//开始补全
		String padStartResult = Strings.padStart("123", minLength, '0');
		System.out.println(padStartResult); //00123
		
	}
	
	/**
	 * 拆分字符串
	 */
	@Test
	public void testSplitter() {
		Iterable<String> iterable = Splitter.onPattern("[,，;]")
											.trimResults()
											.omitEmptyStrings()
											.split("马韶华,张琦，笑笑,,老李，类型 哈哈，非也; 宵夜 ");
		for(String item : iterable) {
			System.out.println(item);
		}
		
		//二次拆分
		String toSplitString = "a=1; b=2, c=3";
		Map<String, String> kvs = Splitter.onPattern("[;,]")
										  .trimResults()
										  .omitEmptyStrings()
										  .withKeyValueSeparator("=")
										  .split(toSplitString);
		
		System.out.println(kvs); //{a=1, b=2, c=3}
	}
	
	/**
	 * 字符串合并
	 */
	@Test
	public void testJoin() {
		
		String users = Joiner.on(",").join(new String[]{"张三", "李四", "王五"});
		System.out.println(users); //张三,李四,王五
		
		//将Map<String, String>合并
		Map<String, String> dataMap = Maps.newHashMap();
		dataMap.put("1001", "张三");
		dataMap.put("1002", "李四");
		dataMap.put("1003", "王五");
		dataMap.put("1004", "马六");
		String mapString = Joiner.on(",").withKeyValueSeparator("=").join(dataMap);
		
		System.out.println(mapString); // 1003=王五,1004=马六,1001=张三,1002=李四
		
		
	}
	
	/**
	 * 重复输出次数
	 */
	@Test
	public void testRepeat() {
		System.out.println(Strings.repeat("1234", 2)); // 12341234
	}
	
	
}
