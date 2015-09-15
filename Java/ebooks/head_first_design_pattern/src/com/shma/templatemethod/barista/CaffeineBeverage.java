package com.shma.templatemethod.barista;

/**
 * 咖啡因公共类
 * @author admin
 *
 */
public abstract class CaffeineBeverage {

	/**
	 * 冲饮料
	 */
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments()) {
			addCondiments();
		}
	}
	
	protected abstract void brew();
	 
	protected abstract void addCondiments();
 
	protected void boilWater() {
		System.out.println("Boiling water");
	}
 
	protected void pourInCup() {
		System.out.println("Pouring into cup");
	}
 
	protected boolean customerWantsCondiments() {
		return true;
	}
}
