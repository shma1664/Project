package com.shma.factory.abstractfactory.pizza;

import com.shma.factory.abstractfactory.PizzaIngredientFactory;

/**
 * ����������࣬�������������������ԭ�Ϲ���
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
