package com.shma.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHql {

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
	public void testSecondQuery() {
		
	}
	
	@Test
	public void testUpdateSQL() {
		String hql = "delete from admin where username = :name";
		Query query = session.createSQLQuery(hql);
		query.setString("name", "shma");
		
		query.executeUpdate();
	}
	
	@Test
	public void testNativeSQL() {
		
		String hql = "insert into admin (username, password) values (?, ?)";
		
		Query query = session.createSQLQuery(hql);
		query.setString(0, "shma")
			 .setString(1, "123456");
		
		query.executeUpdate();
	}
	
	@Test
	public void testQBC4() {
		Criteria criteria = session.createCriteria(Job.class);
		
		criteria.addOrder(Order.asc("job_id"));
		criteria.addOrder(Order.desc("modify_date"));
		
		int pageNo = 1;
		int pageSize = 5;
		
		criteria.setMaxResults(pageSize)
				.setFirstResult((pageNo - 1) * pageSize);
		
		System.out.println(criteria.list());
	} 
	
	@Test
	public void testQBC3() {
		Criteria criteria = session.createCriteria(Job.class);
		criteria.setProjection(Projections.max("job_id"));
		
		System.out.println(criteria.uniqueResult());
	}
	
	@Test
	public void testQBC2() {
		Criteria criteria = session.createCriteria(Job.class);
		Conjunction conjunction = Restrictions.conjunction();
		conjunction.add(Restrictions.like("job_name", "Java", MatchMode.ANYWHERE));
		conjunction.add(Restrictions.isNotNull("job_description"));
		
		System.out.println(conjunction);
		
		Disjunction disjunction = Restrictions.disjunction();
		Department department = new Department();
		department.setDepartId(1);
		disjunction.add(Restrictions.eq("dept", department));
		disjunction.add(Restrictions.isNull("modify_date"));
		
		System.out.println(disjunction);
		
		criteria.add(conjunction);
		criteria.add(disjunction);
		
		System.out.println(criteria.uniqueResult());;
	}
	
	@Test
	public void testQBC() {
		Criteria criteria = session.createCriteria(Job.class);
		criteria.add(Restrictions.eq("job_name", "Java软件开发工程师（后台）"));
		criteria.add(Restrictions.isNotNull("job_description"));
		
		Job job = (Job) criteria.uniqueResult();
		System.out.println(job);
	}
	
	@Test
	public void testGroupQuery() {
		
		String hql = "select min(j.job_id), max(j.job_id) "
						+ "from Job j where "
						+ "j.is_valid = :isValid "
						+ "group by j.dept "
						+ "having min(j.job_id) > :minId";
		
		Query query = session.createQuery(hql);
		List<Object[]> data = query.setInteger("isValid", 1)
			 .setInteger("minId", 4).list();
		
		for(Object[] obj : data) {
			System.out.println(Arrays.asList(obj));
		}
		
		
	}
	
	@Test
	public void testFieldQuery2() {
		String hql = "select new Job(j.job_name, j.job_description, j.dept) from Job j where j.is_valid = :isvalid and j.dept = :dept";
		
		Query query = session.createQuery(hql);
		Department dept = new Department();
		dept.setDepartId(2);
		query.setInteger("isvalid", 1);
		query.setEntity("dept", dept);
		
		List<Job> jobs = query.list();
		for(Job job : jobs) {
			System.out.println(job);
		}
	}
	
	@Test
	public void testFieldQuery() {
		String hql = "select j.job_name, j.job_description, j.dept from Job j where j.is_valid = :isvalid and j.dept = :dept";
		
		Query query = session.createQuery(hql);
		Department dept = new Department();
		dept.setDepartId(2);
		query.setInteger("isvalid", 1);
		query.setEntity("dept", dept);
		
		List<Object[]> data = query.list();
		for(Object[] obj : data) {
			System.out.println(Arrays.asList(obj));
		}
	}
	
	@Test
	public void testNamedQuery() {
		Query query = session.getNamedQuery("getJobs");
		
		List<Job> jobs = query.setInteger("isvalid", 1)
			 .setInteger("minDeptId", 2)
			 .setInteger("maxDeptId", 4).list();
		
		System.out.println(jobs);
	}
	
	@Test
	public void testPageQuery() {
	
		String hql = "from Job j where j.is_valid = :isvalid";
		
		int pageNo = 3;
		int pageSize = 5;
		
		Query query = session.createQuery(hql);
		List<Job> jobs = query.setInteger("isvalid", 1)
							  .setFirstResult((pageNo - 1) * pageSize)
							  .setMaxResults(pageSize).list();
		
		System.out.println(jobs);
		
	}
	
	@Test
	public void testHQLNamedParameter() {
		String hql = "from Job j where j.is_valid = :isvalid and j.dept = :dept";
		Query query = session.createQuery(hql);
		
		Department dept = new Department();
		dept.setDepartId(2);
		
		query.setInteger("isvalid", 1)
			 .setEntity("dept", dept);
		
		List<Job> jobs = query.list();
		System.out.println(jobs.size());
	}
	
	@Test
	public void testHql() {
		String hql = "from Job j where j.is_valid = ? and j.dept = ?";
		Query query = session.createQuery(hql);
		
		Department dept = new Department();
		dept.setDepartId(3);
		
		query.setInteger(0, 1)
			 .setEntity(1, dept);
		
		List<Job> jobs = query.list();
		System.out.println(jobs.size());
	}

}
