package com.shma.spring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬��������
 * 
 * @author h p
 *
 */
public class BeanStaticFactory {

	private static Map<String, Car> beans = new HashMap<String, Car>();
	
	static {
		beans.put("audi", new Car("audi", "A4", 300000, 300));
		beans.put("dazong", new Car("dazong", "ɣ����", 130000, 260));
	}
	
	public static Car getCar(String name) {
		return beans.get(name);
	}
}
