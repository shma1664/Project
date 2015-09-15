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
	 * clear(): ������
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
	 * reflesh():��ǿ�Ʒ��� SELECT ���, ��ʹ Session �����ж����״̬�����ݱ��ж�Ӧ�ļ�¼����һ��!ʹ���ݿ��еļ�¼ͬ����session������
	 */
	@Test
	public void reflesh() {
		
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
		session.refresh(user);
		System.out.println(user);
	}
	
	/**
	 * flush(): ʹsession�����е�����ͬ�������ݿ��У�Ϊ�˱���һ�£����ܻᷢ�Ͷ�Ӧ��SQL������
	 * 
	 * flush()�����õ�������
	 * 	1) �ֶ�����session.flush()����
	 * 	2) ��Transaction�����ύ����֮ǰ�����ȵ���session�����flush()���������ύ����
	 * 	3) ִ��HQL����QBC��ѯʱ����������г־û��������Է����仯�������flush()һ�Σ��Ա�֤��ѯ�����������µ�����
	 * 	4) ����־û�������������native����OID����¼�� ID ���ɵײ����ݿ�ʹ�������ķ�ʽ���ɣ����ڵ���save()����ʱ���ȷ���insert()��䣬�Դ�������id����֤save()����������id�Ǵ��ڵ�
	 */
	@Test
	public void testSessionFlush() {
//		User user = (User) session.get(User.class, 1);
//		user.setAge(27);
//		user.setName("�뽿��");
//		
//		session.flush(); //��session�����е�����ͬ�������ݿ��У�ִ��update�������������ݿ�ֵû���޸ģ�û��commit
//		System.out.println(user);
		
//		User user = (User) session.get(User.class, 1);
//		
//		//ִ��HQL����QBC��ѯʱ����������г־û��������Է����仯�������flush()һ�Σ��Ա�֤��ѯ�����������µ�����
//		User user2 = (User) session.createCriteria(User.class).uniqueResult();
//		
//		System.out.println(user == user2);
		
		
		User user3 = new User("����", 28, new Date());
		session.save(user3);

	}

	/**
	 * ��֤session����
	 */
	@Test
	public void testSessionCache() {
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
		
		User user2 = (User) session.get(User.class, 1); //��session�����л�ȡ��û�в�ѯ���ݿ�
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
