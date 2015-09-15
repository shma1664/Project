package com.shma.factory.simplefactory;

import com.shma.factory.PizzaType;
import com.shma.factory.simplefactory.pizza.Pizza;

public class PizzaTestMain {

	public static void main(String[] args) {
		//创建一个简单披萨工厂
		SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
		//创建一个披萨商店，传递制作披萨的工厂simplePizzaFactory
		PizzaStore store = new PizzaStore(simplePizzaFactory);
		
		//客户下订单制作chess口味的披萨
		Pizza pizza = store.orderPizza(PizzaType.CHESS);
		System.out.println(pizza);
		
		//客户下订单制作veggie口味的披萨
		pizza = store.orderPizza(PizzaType.VEGGIE);
		System.out.println(pizza);
	}
}
