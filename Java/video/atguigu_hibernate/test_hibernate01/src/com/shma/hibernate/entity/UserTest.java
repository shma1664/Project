package com.shma.hibernate.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		//1) 创建一个SessionFactory对象
		SessionFactory sessionFactory = null;
		
		//创建Configuration配置对象，加载hibernate基本配置文件和关系对象映射文件
		Configuration configuration = new Configuration().configure();
		
		//弃用
//		sessionFactory = configuration.buildSessionFactory();
		
		//创建ServiceRegistry服务注册对象，hibernate任何配置和服务都需要在这个对象中注册后才可以使用
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
											.applySettings(configuration.getProperties())
											.buildServiceRegistry();
		
		try {
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		//2) 创建一个Session对象
		Session session = sessionFactory.openSession();
		
		//3) 开启事务
		Transaction transaction = session.beginTransaction();
		
		//4) 执行相关操作
		User user = null;
		try {
			user = new User("马韶华", 23, new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1989-11-10").getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.save(user);
//		User user2 = (User) session.get(User.class, 2);
//		System.out.println(user2);
		
		//5) 提交事务
		transaction.commit();
		
		//6) 关闭Session对象
		session.close();
		
		//7) 关闭SessionFactroy对象
		sessionFactory.close();
	}

}
