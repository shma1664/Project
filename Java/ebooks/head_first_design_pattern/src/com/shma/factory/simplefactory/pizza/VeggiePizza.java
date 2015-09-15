package com.shma.factory.simplefactory.pizza;

/**
 * 具体的披萨实现类
 * @author admin
 *
 */
public class VeggiePizza extends Pizza {
	public VeggiePizza() {
		name = "Veggie Pizza";
		dough = "Crust";
		sauce = "Marinara sauce";
		toppings.add("Shredded mozzarella");
		toppings.add("Grated parmesan");
		toppings.add("Diced onion");
		toppings.add("Sliced mushrooms");
		toppings.add("Sliced red pepper");
		toppings.add("Sliced black olives");
	}
}
