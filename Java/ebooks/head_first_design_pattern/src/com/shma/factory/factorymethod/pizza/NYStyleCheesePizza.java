package com.shma.factory.factorymethod.pizza;

/**
 * 具体的纽约风味pizza实现类
 * @author admin
 *
 */
public class NYStyleCheesePizza extends Pizza {

	public NYStyleCheesePizza() { 
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
 
		toppings.add("Grated Reggiano Cheese");
	}
}
