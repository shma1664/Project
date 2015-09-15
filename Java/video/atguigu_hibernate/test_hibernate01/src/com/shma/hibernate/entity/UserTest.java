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
		//1) ����һ��SessionFactory����
		SessionFactory sessionFactory = null;
		
		//����Configuration���ö��󣬼���hibernate���������ļ��͹�ϵ����ӳ���ļ�
		Configuration configuration = new Configuration().configure();
		
		//����
//		sessionFactory = configuration.buildSessionFactory();
		
		//����ServiceRegistry����ע�����hibernate�κ����úͷ�����Ҫ�����������ע���ſ���ʹ��
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
											.applySettings(configuration.getProperties())
											.buildServiceRegistry();
		
		try {
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		//2) ����һ��Session����
		Session session = sessionFactory.openSession();
		
		//3) ��������
		Transaction transaction = session.beginTransaction();
		
		//4) ִ����ز���
		User user = null;
		try {
			user = new User("���ػ�", 23, new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1989-11-10").getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.save(user);
//		User user2 = (User) session.get(User.class, 2);
//		System.out.println(user2);
		
		//5) �ύ����
		transaction.commit();
		
		//6) �ر�Session����
		session.close();
		
		//7) �ر�SessionFactroy����
		sessionFactory.close();
	}

}
