package com.shma.common.collections;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TestCollections {


	/**
	 * 双端map
	 * 通过key可以找到value，通过value也可以找到key
	 * key和value均不可以重复
	 * @throws Exception
	 */
	@Test
	public void testBidiMap() throws Exception {
		
		System.out.println(StringUtils.center("BidiMap Test", 40, "-"));
		
		BidiMap<String, String> bidiMap = new DualHashBidiMap<String, String>();
		
		bidiMap.put("BJ", "Beijing");
		bidiMap.put("SH", "Shanghai");
		bidiMap.put("WH", "Wuhu");
		bidiMap.put("NJ", "Nanjing");
		bidiMap.put("XA", "Xian");
		
		System.out.println("key-value : BJ-" + bidiMap.get("BJ"));
		System.out.println("value-key : Wuhu-" + bidiMap.getKey("Wuhu"));
	}
	
	/**
	 * 一个key对应多个value
	 * 通过key获取value值，返回一个列表集合
	 * @throws Exception
	 */
	@Test
	public void testMultiMap() throws Exception {
		MultiMap<String, String> multiMap = new MultiValueMap<String, String>();
		multiMap.put("张三", "Java");
		multiMap.put("张三", "PHP");
		multiMap.put("张三", "MySQL");
		multiMap.put("张三", "JavaScript");
		
		multiMap.put("李四", "Python");
		multiMap.put("李四", ".NET");
		multiMap.put("李四", "MySQL");
		
		System.out.println(multiMap.get("张三"));
		System.out.println(multiMap.get("李四"));
	}
	
	/**
	 * Map迭代器实现
	 */
	@Test
	public void iteratorMap() {
		
		IterableMap<Integer, String> iterableMap = new HashedMap<Integer, String>();
		iterableMap.put(1001, "张三");
		iterableMap.put(1002, "李四");
		iterableMap.put(1003, "王五");
		iterableMap.put(1004, "马六");
		
		MapIterator<Integer, String> mapIterator = iterableMap.mapIterator();
		while(mapIterator.hasNext()) {
			System.out.println("key:" + mapIterator.next() + " , value:" + mapIterator.getValue());
		}
	}
	
	/**
	 * 有序的map
	 */
	@Test
	public void sortMap() {
		
		OrderedMap<Integer, String> orderedMap = new LinkedMap<Integer, String>();
		orderedMap.put(1, "张三");
		orderedMap.put(2, "李四");
		orderedMap.put(3, "王五");
		orderedMap.put(4, "马六");
		orderedMap.put(5, "陶七");
		
		System.out.println(orderedMap.firstKey());
	}
	
	@Test
	public void testCollectionsUtil() {
		
		List<Integer> idsList = new ArrayList<Integer>();
		List<Integer> idsList2 = new ArrayList<Integer>();
		idsList.add(1);
		idsList.add(2);
		idsList.add(3);
		
		idsList2.add(2);
		idsList2.add(3);
		idsList2.add(4);
		
		System.out.println(CollectionUtils.retainAll(idsList, idsList2));
	}
	
}
