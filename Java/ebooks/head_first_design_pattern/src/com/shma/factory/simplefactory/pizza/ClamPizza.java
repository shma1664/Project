package com.shma.factory.simplefactory.pizza;

/**
 * ���������ʵ����
 * @author admin
 *
 */
public class ClamPizza extends Pizza {

	public ClamPizza() {
		name = "Clam Pizza";
		dough = "Thin crust";
		sauce = "White garlic sauce";
		toppings.add("Clams");
		toppings.add("Grated parmesan cheese");
	}
}
