package com.shma.factory.factorymethod;

import com.shma.factory.PizzaType;
import com.shma.factory.factorymethod.pizza.Pizza;
import com.shma.factory.factorymethod.pizzastore.ChicagoPizzaStore;
import com.shma.factory.factorymethod.pizzastore.NYPizzaStore;
import com.shma.factory.factorymethod.pizzastore.PizzaStore;

public class PizzaTestMain {

	public static void main(String[] args) {
		//新建一个纽约商店
		PizzaStore nyStore = new NYPizzaStore();
		//新建一个纽约商店
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		
		//纽约商店下一个芝士风味的披萨
		Pizza pizza = nyStore.orderPizza(PizzaType.CHESS);
		System.out.println(pizza);
		
		//芝加哥商店下一个芝士风味的披萨
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
