package com.shma.factory.simplefactory;

import com.shma.factory.PizzaType;
import com.shma.factory.simplefactory.pizza.Pizza;


/**
 * ≈˚»¯…ÃµÍ¿‡
 * @author admin
 *
 */
public class PizzaStore {

	private SimplePizzaFactory simplePizzaFactory;
	
	public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
		this.simplePizzaFactory = simplePizzaFactory;
	}
	
	public Pizza orderPizza(PizzaType type) {
		Pizza pizza = simplePizzaFactory.createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
		
	}
}
