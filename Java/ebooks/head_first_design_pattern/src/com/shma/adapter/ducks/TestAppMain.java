package com.shma.adapter.ducks;

public class TestAppMain {

	public static void main(String[] args) {
		
		//新建一只绿头鸭
		Duck duck = new MallardDuck();
		
		//新建一只野生火鸡
		Turkey turkey = new WildTurkey();
		
		System.out.println("The Duck says...");
		duck.quack();
		duck.fly();
		
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();
		
		//用一只鸭子去适配成一个火鸡
		Turkey duckTurkey = new DuckAdapter(duck);
		duckTurkey.gobble();
		duckTurkey.fly();
		
		//用一只火鸡去适配成有鸭子
		Duck turkeyDuck = new TurkeyAdapter(turkey);
		turkeyDuck.quack();
		turkeyDuck.fly();
	}
}
