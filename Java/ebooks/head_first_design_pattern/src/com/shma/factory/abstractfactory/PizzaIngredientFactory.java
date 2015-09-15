package com.shma.factory.abstractfactory;

import com.shma.factory.abstractfactory.ingredient.Cheese;
import com.shma.factory.abstractfactory.ingredient.Clams;
import com.shma.factory.abstractfactory.ingredient.Dough;
import com.shma.factory.abstractfactory.ingredient.Pepperoni;
import com.shma.factory.abstractfactory.ingredient.Sauce;
import com.shma.factory.abstractfactory.ingredient.Veggies;

/**
 * �������ϳ��󹤳��࣬��װ�˻�ȡ���е��ϵĹ�������
 * @author admin
 *
 */
public interface PizzaIngredientFactory {
	
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
	
}
