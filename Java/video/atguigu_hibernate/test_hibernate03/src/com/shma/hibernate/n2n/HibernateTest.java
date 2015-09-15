package com.shma.hibernate.n2n;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.ietf.jgss.Oid;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {
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
	public void testGet() {
		Categary categary = (Categary) session.get(Categary.class, 1);
		
		System.out.println(categary.getCateName());
		
		System.out.println(categary.getItems().getClass());
		
		System.out.println(categary.getItems().size());
		
		
		Item item = (Item) session.get(Item.class, 2);
		
		System.out.println(item.getItemName());
		System.out.println(item.getCategaries().getClass());
		System.out.println(item.getCategaries().size());
	}
	
	@Test
	public void testSave() {
		Categary categary1 = new Categary();
		categary1.setCateName("CC-11");
		
		Categary categary2 = new Categary();
		categary2.setCateName("CC-22");
		
		Item item1 = new Item();
		item1.setItemName("II-01");
		
		Item item2 = new Item();
		item2.setItemName("II-02");
		
		categary1.getItems().add(item1);
		categary1.getItems().add(item2);
		
		categary2.getItems().add(item1);
		categary2.getItems().add(item2);
		
		item1.getCategaries().add(categary1);
		item1.getCategaries().add(categary2);
		
		item2.getCategaries().add(categary1);
		item2.getCategaries().add(categary2);
		
		
		session.save(categary1);
		session.save(categary2);
		
		session.save(item1);
		session.save(item2);
	}
}
