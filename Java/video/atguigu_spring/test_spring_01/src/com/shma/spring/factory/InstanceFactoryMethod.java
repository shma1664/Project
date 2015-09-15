package com.shma.spring.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceFactoryMethod {

	private Map<String, Car> cars = null;
	
	public InstanceFactoryMethod() {
		cars = new HashMap<String, Car>();
		cars.put("audi", new Car("audi", "A4", 300000, 300));
		cars.put("dazong", new Car("dazong", "É£ËþÄÉ", 130000, 260));
	}
	
	public Car getCar(String name) {
		return cars.get(name);
	}
}
