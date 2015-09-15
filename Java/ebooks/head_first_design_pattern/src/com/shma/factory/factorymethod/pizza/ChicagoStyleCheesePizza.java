package com.shma.factory.factorymethod.pizza;

/**
 * 具体的芝加哥风味pizza实现类
 * @author admin
 *
 */
public class ChicagoStyleCheesePizza extends Pizza {

	public ChicagoStyleCheesePizza() { 
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.add("Shredded Mozzarella Cheese");
	}
 
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
