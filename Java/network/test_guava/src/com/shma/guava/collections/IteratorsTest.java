package com.shma.guava.collections;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * 新增迭代器
 * @author admin
 *
 */
public class IteratorsTest {

	/**
	 * 判断迭代器中的元素是否都满足某一个条件
	 * 全部满足才为true
	 */
	@Test
	public void testAll() {
		List<String> friuts = Lists.newArrayList("Apple","Pear","Peach","Banana");
		
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				return input.startsWith("P");
			}
		};
		
		boolean allIsStartsWithP = Iterators.all(friuts.iterator(), predicate);
		System.out.println(allIsStartsWithP); //false
	}
	
	/**
	 * 判断迭代器中是否有一个满足条件的记录
	 * 只要有一个满足 则返回true
	 */
	@Test
	public void testAny() {
			List<String> friuts = Lists.newArrayList("Apple","Pear","Peach","Banana");
			
			Predicate<String> predicate = new Predicate<String>() {

				@Override
				public boolean apply(String input) {
					return input.startsWith("A");
				}
			};
			
			boolean allIsStartsWithP = Iterators.any(friuts.iterator(), predicate);
			System.out.println(allIsStartsWithP); //true
	}
	
	/**
	 * get方法获得迭代器中的第x个元素
	 */
	@Test
	public void testGet() {
		List<String> friuts = Lists.newArrayList("Apple","Pear","Peach","Banana");
		System.out.println(Iterators.get(friuts.iterator(), 2)); //Peach
		
	}
	
	/**
	 * filter方法过滤符合条件的项
	 */
	@Test
	public void testFilter() {
		List<String> friuts = Lists.newArrayList("Apple","Pear","Peach","Banana");
		
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				return input.startsWith("P");
			}
		};
		
		Iterator<String> startPElements = Iterators.filter(friuts.iterator(), predicate);
		
		System.out.println(Iterators.toString(startPElements)); //[Pear, Peach]
	}
	
	/**
	 * find方法返回符合条件的第一个元素
	 */
	@Test
	public void testFind() {
		
		List<String> friuts = Lists.newArrayList("Apple","Pear","Peach","Banana");
		
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				return input.startsWith("P");
			}
		};
		
		String find = Iterators.find(friuts.iterator(), predicate);
		System.out.println(find); //Pear
		
	}
	
	/**
	 * 对迭代器元素做转换
	 */
	@Test
	public void testTransform() {
		List<String> friuts = Lists.newArrayList("Apple","Pear","Peach","Banana");
		
		//字符串转换成了其长度
		Iterator<Integer> lengths = Iterators.transform(friuts.iterator(), new Function<String, Integer>() {

			@Override
			public Integer apply(String input) {
				return input.length();
			}
		});
		
		System.out.println(Iterators.toString(lengths)); //[5, 4, 5, 6]
		
	}
}
