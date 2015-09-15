package com.shma.factory.abstractfactory.pizzastore;

import com.shma.factory.PizzaType;
import com.shma.factory.abstractfactory.NYPizzaIngredientFactory;
import com.shma.factory.abstractfactory.PizzaIngredientFactory;
import com.shma.factory.abstractfactory.pizza.CheesePizza;
import com.shma.factory.abstractfactory.pizza.ClamPizza;
import com.shma.factory.abstractfactory.pizza.PepperoniPizza;
import com.shma.factory.abstractfactory.pizza.Pizza;
import com.shma.factory.abstractfactory.pizza.VeggiePizza;

/**
 * ¾ßÌåÅ¦Ô¼ÅûÈøµê
 * @author admin
 *
 */
public class NYPizzaStore extends PizzaStore {

	private PizzaIngredientFactory ingredientFactory;
	
	public NYPizzaStore(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	@Override
	public Pizza createPizza(PizzaType pizzaType) {
		Pizza pizza = null;
		
		switch(pizzaType) {
			case CHESS :
				pizza = new CheesePizza(ingredientFactory);
				pizza.setName("New York Style Cheese Pizza");
				break;
			case CLAM :
				pizza = new ClamPizza(ingredientFactory);
				pizza.setName("New York Style Clam Pizza");
				break;
			case PEPPERONI :
				pizza = new PepperoniPizza(ingredientFactory);
				pizza.setName("New York Style Pepperoni Pizza");
				break;
			case VEGGIE :
				pizza = new VeggiePizza(ingredientFactory);
				pizza.setName("New York Style Veggie Pizza");
				break;
		
		}
		
		return pizza;
	}

}
