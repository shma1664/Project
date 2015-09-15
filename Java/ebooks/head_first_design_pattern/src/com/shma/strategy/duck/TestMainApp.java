package com.shma.strategy.duck;

import java.sql.DriverManager;
import java.util.EnumSet;

import com.shma.strategy.duck.fly.FlyRocketPowered;

public class TestMainApp {

	public static void main(String[] args) {
		Duck duck = new DecoyDuck("ÓÕ¶üÑ¼");
		duck.display();
		duck.swim();
		duck.fly();
		duck.sing();
		
		duck = new MallardDuck("ÂÌÍ·Ñ¼");
		duck.display();
		duck.swim();
		duck.fly();
		duck.sing();
		
		duck = new ModelDuck("ÂÌÍ·Ñ¼");
		duck.display();
		duck.swim();
		duck.fly();
		duck.sing();
		
		duck.setFlyBehavior(new FlyRocketPowered());
		duck.fly();
	}
}
