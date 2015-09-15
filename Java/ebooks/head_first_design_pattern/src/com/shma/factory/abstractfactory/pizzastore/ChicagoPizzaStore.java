package com.shma.factory.abstractfactory.pizzastore;

import com.shma.factory.PizzaType;
import com.shma.factory.abstractfactory.ChicagoPizzaIngredientFactory;
import com.shma.factory.abstractfactory.PizzaIngredientFactory;
import com.shma.factory.abstractfactory.pizza.CheesePizza;
import com.shma.factory.abstractfactory.pizza.ClamPizza;
import com.shma.factory.abstractfactory.pizza.PepperoniPizza;
import com.shma.factory.abstractfactory.pizza.Pizza;
import com.shma.factory.abstractfactory.pizza.VeggiePizza;

/**
 * æﬂÃÂ÷•º”∏Á≈˚»¯µÍ
 * @author admin
 *
 */
public class ChicagoPizzaStore extends PizzaStore {

	private PizzaIngredientFactory ingredientFactory;
	
	public ChicagoPizzaStore(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	@Override
	public Pizza createPizza(PizzaType pizzaType) {
		Pizza pizza = null;
		
		switch(pizzaType) {
			case CHESS :
				pizza = new CheesePizza(ingredientFactory);
				pizza.setName("Chicago Style Cheese Pizza");
				break;
			case CLAM :
				pizza = new VeggiePizza(ingredientFactory);
				pizza.setName("Chicago Style Veggie Pizza");
				break;
			case PEPPERONI :
				pizza = new ClamPizza(ingredientFactory);
				pizza.setName("Chicago Style Clam Pizza");
				break;
			case VEGGIE :
				pizza = new PepperoniPizza(ingredientFactory);
				pizza.setName("Chicago Style Pepperoni Pizza");
				break;
		
		}
		
		return pizza;
	}

}
