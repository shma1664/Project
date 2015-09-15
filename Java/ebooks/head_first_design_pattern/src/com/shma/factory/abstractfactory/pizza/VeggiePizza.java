package com.shma.factory.abstractfactory.pizza;

import com.shma.factory.abstractfactory.PizzaIngredientFactory;

/**
 * 具体的披萨类，引入了相关披萨创建的原料工厂
 * @author admin
 *
 */
public class VeggiePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		veggies = ingredientFactory.createVeggies();
	}
}
