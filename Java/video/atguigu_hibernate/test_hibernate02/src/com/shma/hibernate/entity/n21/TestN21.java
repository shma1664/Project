package com.shma.hibernate.entity.n21;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestN21 {

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
	public void testMany2OneDel() {
//		Order order = (Order)session.get(Order.class, 2); 
//		session.delete(order);
//		
//		session.delete(order.getCustomer());
		
		//在不设定级联关系的情况下, 且 1 这一端的对象有 n 的对象在引用, 不能直接删除 1 这一端的对象
		Customer customer = (Customer) session.get(Customer.class, 2);
		session.delete(customer);
		
		
	}
	
	@Test
	public void testMany2OneUpdate() {
		Order order = (Order)session.get(Order.class, 1);
		order.setOrderName("order-112222");
		order.getCustomer().setCustomerName("AAAAAAAA");
	}
	
	@Test
	public void testMany2OneGet() {
		Order order = (Order)session.get(Order.class, 1);
		System.out.println(order);
		System.out.println(order.getCustomer().getClass());
		
		//如果session被关闭，将抛出异常
//		session.close();

		//延时加载Customer
		Customer customer = order.getCustomer();
		System.out.println(customer);
		
		System.out.println(customer.getClass());
		
	}
	
	@Test
	public void testMany2OneSave() {
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
//		//先savecustomer，会saveorder，执行三次insert
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
		
		//先save order，会save customer，执行三次insert，会执行2次update
		session.save(order01);
		session.save(order02);
		session.save(customer);
		
		
		
	}

}
