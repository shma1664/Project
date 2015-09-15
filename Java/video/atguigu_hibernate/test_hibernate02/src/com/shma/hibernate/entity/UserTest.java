package com.shma.hibernate.entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction transaction = null;
	
	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = 
						new ServiceRegistryBuilder().applySettings(configuration.getProperties())
													.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	/**
	 * clear(): 清理缓存
	 */
	@Test
	public void clear() {
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
		User user2 = (User) session.get(User.class, 1);
		System.out.println(user2);
		session.clear();
		
		User user3 = (User) session.get(User.class, 1);
		System.out.println(user3);
	}
	
	/**
	 * reflesh():会强制发送 SELECT 语句, 以使 Session 缓存中对象的状态和数据表中对应的记录保持一致!使数据库中的记录同步到session缓存中
	 */
	@Test
	public void reflesh() {
		
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
		session.refresh(user);
		System.out.println(user);
	}
	
	/**
	 * flush(): 使session缓存中的数据同步到数据库中，为了保存一致，可能会发送对应的SQL语句操作
	 * 
	 * flush()被调用的契机：
	 * 	1) 手动调用session.flush()方法
	 * 	2) 在Transaction对象提交事务之前，会先调用session对象的flush()方法，在提交事务
	 * 	3) 执行HQL或者QBC查询时，如果缓存中持久化对象属性发生变化，则会先flush()一次，以保证查询出来的是最新的数据
	 * 	4) 如果持久化对象主键采用native生成OID（记录的 ID 是由底层数据库使用自增的方式生成），在调用save()方法时，先发生insert()语句，以创建主键id，保证save()方法后主键id是存在的
	 */
	@Test
	public void testSessionFlush() {
//		User user = (User) session.get(User.class, 1);
//		user.setAge(27);
//		user.setName("齐娇娇");
//		
//		session.flush(); //将session缓存中的数据同步到数据库中，执行update方法，但是数据库值没有修改，没有commit
//		System.out.println(user);
		
//		User user = (User) session.get(User.class, 1);
//		
//		//执行HQL或者QBC查询时，如果缓存中持久化对象属性发生变化，则会先flush()一次，以保证查询出来的是最新的数据
//		User user2 = (User) session.createCriteria(User.class).uniqueResult();
//		
//		System.out.println(user == user2);
		
		
		User user3 = new User("孙威", 28, new Date());
		session.save(user3);

	}

	/**
	 * 验证session缓存
	 */
	@Test
	public void testSessionCache() {
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
		
		User user2 = (User) session.get(User.class, 1); //从session缓存中获取，没有查询数据库
		System.out.println(user2);
		
		System.out.println(user == user2);
	}
	
	@After
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
