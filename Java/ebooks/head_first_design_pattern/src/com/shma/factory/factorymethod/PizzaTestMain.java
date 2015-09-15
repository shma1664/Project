package com.shma.factory.factorymethod;

import com.shma.factory.PizzaType;
import com.shma.factory.factorymethod.pizza.Pizza;
import com.shma.factory.factorymethod.pizzastore.ChicagoPizzaStore;
import com.shma.factory.factorymethod.pizzastore.NYPizzaStore;
import com.shma.factory.factorymethod.pizzastore.PizzaStore;

public class PizzaTestMain {

	public static void main(String[] args) {
		//�½�һ��ŦԼ�̵�
		PizzaStore nyStore = new NYPizzaStore();
		//�½�һ��ŦԼ�̵�
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		
		//ŦԼ�̵���һ��֥ʿ��ζ������
		Pizza pizza = nyStore.orderPizza(PizzaType.CHESS);
		System.out.println(pizza);
		
		//֥�Ӹ��̵���һ��֥ʿ��ζ������
		chicagoStore.orderPizza(PizzaType.CHESS);
		System.out.println(pizza);
		
		pizza = nyStore.orderPizza(PizzaType.CLAM);
		System.out.println(pizza);
		
		chicagoStore.orderPizza(PizzaType.CLAM);
		System.out.println(pizza);
		
		pizza = nyStore.orderPizza(PizzaType.CLAM);
		System.out.println(pizza);
		
		chicagoStore.orderPizza(PizzaType.PEPPERONI);
		System.out.println(PizzaType.PEPPERONI);
	}
}
