package com.shma.guava.collections;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;

public class CollectionTools {

	@Test
	public void test() {
		Set<String> names = Sets.newHashSet("shma", "jjq");
		List<Integer> ids = Lists.newArrayList(1,2,3,5);
		
		List<Integer> idsList = Lists.newArrayListWithCapacity(100);
		
		Multiset<String> multiset = HashMultiset.create();
	}
}
