package com.shma.factory.abstractfactory;

import com.shma.factory.PizzaType;
import com.shma.factory.abstractfactory.pizza.Pizza;
import com.shma.factory.abstractfactory.pizzastore.ChicagoPizzaStore;
import com.shma.factory.abstractfactory.pizzastore.NYPizzaStore;
import com.shma.factory.abstractfactory.pizzastore.PizzaStore;

public class PizzaTestMain {

	public static void main(String[] args) {
		
		//创建原料工厂
		PizzaIngredientFactory nyPizzaIngredientFactory = new NYPizzaIngredientFactory();
		PizzaIngredientFactory chPizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
		
		//创建披萨商店
		PizzaStore pizzaStore = new NYPizzaStore(nyPizzaIngredientFactory);
		PizzaStore chPizzaStore = new ChicagoPizzaStore(chPizzaIngredientFactory);
		
		Pizza pizza = pizzaStore.orderPizza(PizzaType.CHESS);
		System.out.println(pizza);
		
		pizza = pizzaStore.orderPizza(PizzaType.PEPPERONI);
		System.out.println(pizza);
		
		pizza = chPizzaStore.orderPizza(PizzaType.PEPPERONI);
		System.out.println(pizza);
		
		pizza = chPizzaStore.orderPizza(PizzaType.CLAM);
		System.out.println(pizza);
	}
}
