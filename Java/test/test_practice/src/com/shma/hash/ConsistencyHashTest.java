package com.shma.hash;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ConsistencyHashTest {

	@Test
	public void test() {
		
		System.out.println(45243042L%10);
		
//		ConsistencyHash hash = new ConsistencyHash("1111", 10);
//		hash.init();
//		System.out.println(hash.getTableName("866462028630270"));
//		System.out.println(hash.getTableName("860463023291437"));
//		System.out.println(hash.getTableName("860463023291432"));
//		System.out.println(hash.getTableName("769"));
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		long time = System.currentTimeMillis();
//		for(int i=0; i<10000; ++i) {
//			String key = hash.getTableName(i+"");
//			System.out.println(i + ":" + key);
//			Integer count = map.get(key);
//			if(count == null) {
//				map.put(key, 1);
//			} else {
//				map.put(key, count+1);
//			}
//		}
//		
//		System.out.println(map);
//		System.out.println(System.currentTimeMillis() - time);
	}

}
