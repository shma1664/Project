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
		//在不设定级联关系的情况下, 且 1 这一端的对象有 n 的对象在引用, 不能直接删除 1 这一端的对象
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
		//延时加载
		//返回的多的一端的集合时 Hibernate 内置的集合类型. 
		//该类型具有延迟加载和存放代理对象的功能.
		System.out.println(customer.getOrders().getClass());
		
		//3. 可能会抛出 LazyInitializationException 异常 
//		session.close();
		
		System.out.println(customer.getOrders().iterator().next().getOrderName());
		//再需要使用集合中元素的时候进行初始化. 
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
		
		customer.getOrders().add(order01);
		customer.getOrders().add(order02);
		
		//先save order，会save customer，执行三次insert，会执行2次update
		session.save(order01);
		session.save(order02);
		session.save(customer);
		
		
		
	}

}
