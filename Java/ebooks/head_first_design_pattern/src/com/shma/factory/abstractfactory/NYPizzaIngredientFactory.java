package com.shma.factory.abstractfactory;

import com.shma.factory.abstractfactory.ingredient.Cheese;
import com.shma.factory.abstractfactory.ingredient.Clams;
import com.shma.factory.abstractfactory.ingredient.Dough;
import com.shma.factory.abstractfactory.ingredient.FreshClams;
import com.shma.factory.abstractfactory.ingredient.Garlic;
import com.shma.factory.abstractfactory.ingredient.MarinaraSauce;
import com.shma.factory.abstractfactory.ingredient.Mushroom;
import com.shma.factory.abstractfactory.ingredient.Onion;
import com.shma.factory.abstractfactory.ingredient.Pepperoni;
import com.shma.factory.abstractfactory.ingredient.RedPepper;
import com.shma.factory.abstractfactory.ingredient.ReggianoCheese;
import com.shma.factory.abstractfactory.ingredient.Sauce;
import com.shma.factory.abstractfactory.ingredient.SlicedPepperoni;
import com.shma.factory.abstractfactory.ingredient.ThinCrustDough;
import com.shma.factory.abstractfactory.ingredient.Veggies;

/**
 * 具体的生产纽约风味的调料工厂类
 * @author admin
 *
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}

}
