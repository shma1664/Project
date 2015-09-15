package com.shma.factory.abstractfactory;

import com.shma.factory.abstractfactory.ingredient.BlackOlives;
import com.shma.factory.abstractfactory.ingredient.Cheese;
import com.shma.factory.abstractfactory.ingredient.Clams;
import com.shma.factory.abstractfactory.ingredient.Dough;
import com.shma.factory.abstractfactory.ingredient.Eggplant;
import com.shma.factory.abstractfactory.ingredient.FrozenClams;
import com.shma.factory.abstractfactory.ingredient.MozzarellaCheese;
import com.shma.factory.abstractfactory.ingredient.Pepperoni;
import com.shma.factory.abstractfactory.ingredient.PlumTomatoSauce;
import com.shma.factory.abstractfactory.ingredient.Sauce;
import com.shma.factory.abstractfactory.ingredient.SlicedPepperoni;
import com.shma.factory.abstractfactory.ingredient.Spinach;
import com.shma.factory.abstractfactory.ingredient.ThickCrustDough;
import com.shma.factory.abstractfactory.ingredient.Veggies;

/**
 * 具体的生产芝加哥风味的调料工厂类
 * @author admin
 *
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
                new Spinach(), 
                new Eggplant() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FrozenClams();
	}

}
