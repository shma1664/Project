package com.shma.singleton.chocolate;

public class ChocolateController {

	public static void main(String[] args) {
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		
		//装入原料
		boiler.fill();
		//煮沸
		boiler.boil();
		//排出
		boiler.drain();
		
		// will return the existing instance
		ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
	}
}
