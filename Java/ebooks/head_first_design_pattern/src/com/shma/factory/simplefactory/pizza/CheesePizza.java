package com.shma.factory.simplefactory.pizza;

/**
 * 具体的披萨实现类
 * @author admin
 *
 */
public class CheesePizza extends Pizza {
	public CheesePizza() {
		name = "Cheese Pizza";
		dough = "Regular Crust";
		sauce = "Marinara Pizza Sauce";
		toppings.add("Fresh Mozzarella");
		toppings.add("Parmesan");
	}
}
