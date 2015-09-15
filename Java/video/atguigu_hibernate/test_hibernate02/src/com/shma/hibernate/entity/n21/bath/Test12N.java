package com.shma.hibernate.entity.n21.bath;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test12N {

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
	
	@After
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testOne2ManyDel() {
		//�ڲ��趨������ϵ�������, �� 1 ��һ�˵Ķ����� n �Ķ���������, ����ֱ��ɾ�� 1 ��һ�˵Ķ���
		Customer customer = (Customer) session.get(Customer.class, 1);
		session.delete(customer.getOrders().iterator().next());
	}
	
	@Test
	public void testOne2ManyUpdate() {
		
		Customer customer = (Customer) session.get(Customer.class, 1);
		customer.setCustomerName("CCCCCC");
		
		Customer customer2 = (Customer) session.get(Customer.class, 2);
		customer.getOrders().iterator().next().setCustomer(customer2);
		
	}
	
	@Test
	public void testOne2ManyGet() {
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer.getCustomerName());
		//��ʱ����
		//���صĶ��һ�˵ļ���ʱ Hibernate ���õļ�������. 
		//�����;����ӳټ��غʹ�Ŵ������Ĺ���.
		System.out.println(customer.getOrders().getClass());
		
		//3. ���ܻ��׳� LazyInitializationException �쳣 
//		session.close();
		
		System.out.println(customer.getOrders().iterator().next().getOrderName());
		//����Ҫʹ�ü�����Ԫ�ص�ʱ����г�ʼ��. 
	}
	
	@Test
	public void testOne2ManySave() {
		
//		Customer customer = new Customer();
//		customer.setCustomerName("AAA");
//		
//		Order order01 = new Order();
//		order01.setOrderName("Order-01");
//		
//		Order order02 = new Order();
//		order02.setOrderName("Order-02");
//		
//		order01.setCustomer(customer);
//		order02.setCustomer(customer);
//		
//		customer.getOrders().add(order01);
//		customer.getOrders().add(order02);
//		
//		//��savecustomer����saveorder��ִ������insert
//		session.save(customer);
//		session.save(order01);
//		session.save(order02);
		
		
		Customer customer = new Customer();
		customer.setCustomerName("BBB");
		
		Order order01 = new Order();
		order01.setOrderName("Order-03");
		
		Order order02 = new Order();
		order02.setOrderName("Order-04");
		
		order01.setCustomer(customer);
		order02.setCustomer(customer);
		
		customer.getOrders().add(order01);
		customer.getOrders().add(order02);
		
		//��save order����save customer��ִ������insert����ִ��2��update
		session.save(order01);
		session.save(order02);
		session.save(customer);
		
		
		
	}

}
