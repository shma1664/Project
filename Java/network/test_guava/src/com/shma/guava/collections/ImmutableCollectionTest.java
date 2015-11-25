package com.shma.guava.collections;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;

/**
 * 不可变集合
 * 禁止修改（添加、删除），修改的时候会抛出异常java.lang.UnsupportedOperationException
 * 
	可变集合类型				可变集合源：JDK or Guava?	Guava不可变集合
	Collection				JDK						ImmutableCollection
	List					JDK						ImmutableList
	Set						JDK						ImmutableSet
	SortedSet/NavigableSet	JDK						ImmutableSortedSet
	Map						JDK						ImmutableMap
	SortedMap				JDK						ImmutableSortedMap
	Multiset				Guava					ImmutableMultiset
	SortedMultiset			Guava					ImmutableSortedMultiset
	Multimap				Guava					ImmutableMultimap
	ListMultimap			Guava					ImmutableListMultimap
	SetMultimap				Guava					ImmutableSetMultimap
	BiMap					Guava					ImmutableBiMap
	ClassToInstanceMap		Guava					ImmutableClassToInstanceMap
	Table					Guava					ImmutableTable
 * 
 * @author admin
 *
 */
public class ImmutableCollectionTest {

	/**
	 * 1) 通过of方法创建
	 */
	public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
			"red",
	        "orange",
	        "yellow",
	        "green",
	        "blue",
	        "purple");
	
	@Test
	public void testImmutableSet() {
		
		System.out.println(COLOR_NAMES); //不可变集合
		
		//2) 通过copyof方法创建
		List<String> dataList = Lists.newArrayList();
		dataList.add("zhangsan");
		dataList.add("lisi");
		
		ImmutableSet<String> dataImmutableSet = ImmutableSet.copyOf(dataList);
		System.out.println(dataImmutableSet);
		
		//3) Builder
		ImmutableSet<String> colorImmutableSet = ImmutableSet.<String>builder()
															.add("red")
															.add("orange")
															.add("yellow")
															.add("green")
															.add("blue")
															.add("purple")
															.build();
		dataList.add("wangwu");
		
		System.out.println("list:" + dataList);
		System.out.println("immutable list:" + dataImmutableSet);
		
		
		//copyOf
		ImmutableSet<String> nameSet = ImmutableSet.of("shma", "jjq", "sunwei", "fanhui", "zhouwei", "naiwa", "wangjiakuo", "chengjunjie");
		
		ImmutableSet<String> limitSet = ImmutableSortedSet.copyOf(nameSet);
		System.out.println(limitSet);
		
		List<Integer> intList = Lists.newArrayList();
		for(int i=0; i<100; ++i) {
			intList.add(i);
		}
		
		ImmutableSet<Integer> limitIntSet = ImmutableSet.copyOf(intList.subList(0, 10));
		System.out.println(limitIntSet);
		
	}														
	

}
