package com.shma.factory.factorymethod.pizza;

/**
 * �����ŦԼ��ζpizzaʵ����
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
