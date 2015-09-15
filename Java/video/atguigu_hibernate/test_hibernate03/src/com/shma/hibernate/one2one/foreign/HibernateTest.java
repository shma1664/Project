package com.shma.hibernate.one2one.foreign;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
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
	public void testGet2() {
		
		//�ڲ�ѯû�������ʵ�����ʱ, ʹ�õ��������Ӳ�ѯ, һ����ѯ��������Ķ���
		//���Ѿ����г�ʼ��. 
		Department department = (Department) session.get(Department.class, 1);
		
		System.out.println(department.getDeptName());
	}
	
	@Test
	public void testDel() {
		
//		Manager manager = (Manager) session.get(Manager.class, 1);
//		session.delete(manager);
		
		Department department = (Department) session.get(Department.class, 2);
		session.delete(department);
	}
	
	@Test
	public void testUpdate() {
//		Manager manager = (Manager) session.get(Manager.class, 1);
//		manager.setMgrName("Manager-QAAAAAA");
//		manager.getDept().setDeptName("DEPT-BBBBBBB");
		
		Department department = (Department) session.get(Department.class, 2);
		department.setDeptName("DEPT-CCCCCC");
		department.getMgr().setMgrName("MANAGER-EEEEEE");
	}
	
	@Test
	public void testGet() {
		
		//�������������һ�ˣ�������ʱ����
		Manager manager = (Manager) session.get(Manager.class, 1);
		System.out.println(manager.getMgrName());
		
		System.out.println(manager.getDept().getClass());
		
		System.out.println(manager.getDept().getDeptName());
	}

	@Test
	public void testSave() {
		Manager manager = new Manager();
		manager.setMgrName("Mgr-02");
		
		Department department = new Department();
		department.setDeptName("Dept-02");
		
		manager.setDept(department);
		department.setMgr(manager);
		
		session.save(department);
		session.save(manager);
		
		
	}
}
