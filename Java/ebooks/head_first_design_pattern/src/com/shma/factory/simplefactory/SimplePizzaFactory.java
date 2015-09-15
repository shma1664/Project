package com.shma.factory.simplefactory;

import com.shma.factory.PizzaType;
import com.shma.factory.simplefactory.pizza.CheesePizza;
import com.shma.factory.simplefactory.pizza.ClamPizza;
import com.shma.factory.simplefactory.pizza.PepperoniPizza;
import com.shma.factory.simplefactory.pizza.Pizza;
import com.shma.factory.simplefactory.pizza.VeggiePizza;

/**
 * 简单披萨工厂类
 * @author admin
 *
 */
public class SimplePizzaFactory {

	public Pizza createPizza(PizzaType type) {
		Pizza pizza = null;
		switch(type) {
			case CHESS :
				pizza = new CheesePizza();
				break;
			case CLAM :
				pizza = new ClamPizza();
				break;
			case PEPPERONI :
				pizza = new PepperoniPizza();
				break;
			case VEGGIE :
				pizza = new VeggiePizza();
		}
		
		return pizza;
	}
}
