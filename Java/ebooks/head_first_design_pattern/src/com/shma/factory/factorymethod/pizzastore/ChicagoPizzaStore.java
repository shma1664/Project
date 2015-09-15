package com.shma.factory.factorymethod.pizzastore;

import com.shma.factory.PizzaType;
import com.shma.factory.factorymethod.pizza.ChicagoStyleCheesePizza;
import com.shma.factory.factorymethod.pizza.ChicagoStyleClamPizza;
import com.shma.factory.factorymethod.pizza.ChicagoStylePepperoniPizza;
import com.shma.factory.factorymethod.pizza.ChicagoStyleVeggiePizza;
import com.shma.factory.factorymethod.pizza.Pizza;

/**
 * æﬂÃÂ÷•º”∏Á≈˚»¯µÍ
 * @author admin
 *
 */
public class ChicagoPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(PizzaType pizzaType) {
		Pizza pizza = null;
		
		switch(pizzaType) {
			case CHESS :
				pizza = new ChicagoStyleCheesePizza();
				break;
			case CLAM :
				pizza = new ChicagoStyleClamPizza();
				break;
			case PEPPERONI :
				pizza = new ChicagoStylePepperoniPizza();
				break;
			case VEGGIE :
				pizza = new ChicagoStyleVeggiePizza();
		
		}
		
		return pizza;
	}

}
