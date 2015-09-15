package com.shma.factory.factorymethod.pizzastore;

import com.shma.factory.PizzaType;
import com.shma.factory.factorymethod.pizza.NYStyleCheesePizza;
import com.shma.factory.factorymethod.pizza.NYStyleClamPizza;
import com.shma.factory.factorymethod.pizza.NYStylePepperoniPizza;
import com.shma.factory.factorymethod.pizza.NYStyleVeggiePizza;
import com.shma.factory.factorymethod.pizza.Pizza;

/**
 * ¾ßÌåÅ¦Ô¼ÅûÈøµê
 * @author admin
 *
 */
public class NYPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(PizzaType pizzaType) {
		Pizza pizza = null;
		
		switch(pizzaType) {
			case CHESS :
				pizza = new NYStyleCheesePizza();
				break;
			case CLAM :
				pizza = new NYStyleClamPizza();
				break;
			case PEPPERONI :
				pizza = new NYStylePepperoniPizza();
				break;
			case VEGGIE :
				pizza = new NYStyleVeggiePizza();
		
		}
		
		return pizza;
	}

}
