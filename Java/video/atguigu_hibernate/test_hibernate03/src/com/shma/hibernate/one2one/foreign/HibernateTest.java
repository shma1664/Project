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
		
		//在查询没有外键的实体对象时, 使用的左外连接查询, 一并查询出其关联的对象
		//并已经进行初始化. 
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
		
		//对于设置外键的一端，启用延时加载
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
