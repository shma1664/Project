package com.shma.factory.factorymethod.pizza;

/**
 * 具体的纽约风味pizza实现类
 * @author admin
 *
 */
public class NYStyleClamPizza extends Pizza {

	public NYStyleClamPizza() {
		name = "NY Style Clam Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
 
		toppings.add("Grated Reggiano Cheese");
		toppings.add("Fresh Clams from Long Island Sound");
	}
}
