package com.shma.factory.abstractfactory.pizza;

import com.shma.factory.abstractfactory.ingredient.Cheese;
import com.shma.factory.abstractfactory.ingredient.Clams;
import com.shma.factory.abstractfactory.ingredient.Dough;
import com.shma.factory.abstractfactory.ingredient.Pepperoni;
import com.shma.factory.abstractfactory.ingredient.Sauce;
import com.shma.factory.abstractfactory.ingredient.Veggies;

/**
 * 定义一个公共的披萨抽象类
 * @author admin
 *
 */
public abstract class Pizza {
	protected String name;
	protected Dough dough;
	protected Sauce sauce;
	protected Veggies veggies[];
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clam;
 
	public abstract void prepare();
  
	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}
 
	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}
  
	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}
 
	public String getName() {
		return name;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) {
			result.append(dough);
			result.append("\n");
		}
		if (sauce != null) {
			result.append(sauce);
			result.append("\n");
		}
		if (cheese != null) {
			result.append(cheese);
			result.append("\n");
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.length; i++) {
				result.append(veggies[i]);
				if (i < veggies.length-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (clam != null) {
			result.append(clam);
			result.append("\n");
		}
		if (pepperoni != null) {
			result.append(pepperoni);
			result.append("\n");
		}
		return result.toString();
	}

	public void setName(String name) {
		this.name = name;
	}
}
