package com.shma.factory.factorymethod.pizza;

/**
 * 具体的芝加哥风味pizza实现类
 * @author admin
 *
 */
public class ChicagoStyleClamPizza extends Pizza {
	public ChicagoStyleClamPizza() {
		name = "Chicago Style Clam Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.add("Shredded Mozzarella Cheese");
		toppings.add("Frozen Clams from Chesapeake Bay");
	}
 
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
