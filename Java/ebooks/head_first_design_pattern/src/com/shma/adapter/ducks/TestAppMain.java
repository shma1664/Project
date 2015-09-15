package com.shma.adapter.ducks;

public class TestAppMain {

	public static void main(String[] args) {
		
		//�½�һֻ��ͷѼ
		Duck duck = new MallardDuck();
		
		//�½�һֻҰ����
		Turkey turkey = new WildTurkey();
		
		System.out.println("The Duck says...");
		duck.quack();
		duck.fly();
		
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();
		
		//��һֻѼ��ȥ�����һ����
		Turkey duckTurkey = new DuckAdapter(duck);
		duckTurkey.gobble();
		duckTurkey.fly();
		
		//��һֻ��ȥ�������Ѽ��
		Duck turkeyDuck = new TurkeyAdapter(turkey);
		turkeyDuck.quack();
		turkeyDuck.fly();
	}
}
