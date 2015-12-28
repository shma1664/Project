package com.shma.chapter03.test.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shma.chapter03.ioc.LiuDeHua;
import com.shma.chapter03.ioc.MoAttack;

public class MoAttackTest {

	@Test
	public void testAskByConst() {
		//构造器注入
		MoAttack moAttack = new MoAttack(new LiuDeHua("刘德华"));
		moAttack.cityGateAsk();
	}

	@Test
	public void testAskByAttr() {
		//属性注入
		MoAttack moAttack = new MoAttack();
		moAttack.setGeli(new LiuDeHua("刘德华"));
		moAttack.cityGateAsk();
	}
	
	/**
	 * 配置文件方式
	 */
	@Test
	public void testAskByXml() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/config/*.xml");
		MoAttack moAttack = (MoAttack)applicationContext.getBean("moAttack");
		moAttack.cityGateAsk();
		
		moAttack = (MoAttack)applicationContext.getBean("moAttack2");
		moAttack.cityGateAsk();
	}
	
}
