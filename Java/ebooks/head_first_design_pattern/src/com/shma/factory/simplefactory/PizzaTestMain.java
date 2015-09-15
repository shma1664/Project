package com.shma.factory.simplefactory;

import com.shma.factory.PizzaType;
import com.shma.factory.simplefactory.pizza.Pizza;

public class PizzaTestMain {

	public static void main(String[] args) {
		//����һ������������
		SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
		//����һ�������̵꣬�������������Ĺ���simplePizzaFactory
		PizzaStore store = new PizzaStore(simplePizzaFactory);
		
		//�ͻ��¶�������chess��ζ������
		Pizza pizza = store.orderPizza(PizzaType.CHESS);
		System.out.println(pizza);
		
		//�ͻ��¶�������veggie��ζ������
		pizza = store.orderPizza(PizzaType.VEGGIE);
		System.out.println(pizza);
	}
}
