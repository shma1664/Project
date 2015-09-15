package com.shma.hibernate.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest2 {
	
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction transaction = null;
	
	
	@Test
	public void testDate() throws IOException, SQLException {
//		User user = new User("shma", 20, new Date());
//		user.setOldContent("old-CONTENT");
//		
//		InputStream inputstream = new FileInputStream("D:\\QQ��ͼ20150718132013.png");
//		
//		Clob clob = Hibernate.getLobCreator(session).createClob("11111111");
//		user.setRealContent(clob);
//		Blob image = Hibernate.getLobCreator(session).createBlob(inputstream, inputstream.available());
//		user.setImage(image);
//		session.save(user);
		
		User user = (User)session.get(User.class, 1);
		System.out.println(user.getImage().getBinaryStream().available());
	}
	
	@Test
	public void testFormula() {
		User user = (User) session.get(User.class, 4);
		System.out.println(user.getDesc());
	}
	
	/**
	 * ���ô洢����
	 */
	@Test
	public void testDoWork() {
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				//���ô洢����
				//com.mchange.v2.c3p0.impl.NewProxyConnection@7f5338bf
				System.out.println(conn);
			}
		});
	}
	
	/**
	 * evict()���ӻ������Ƴ�ָ���ĳ־û�����
	 */
	@Test
	public void testEvict() {
		User user = (User) session.get(User.class, 8);
		User user2 = (User) session.get(User.class, 9);
		
		user.setName("nihao");
		user2.setName("haha");
		
		session.evict(user);
	
	}
	
	/**
	 * delete: ִ��ɾ������. ֻҪ OID �����ݱ���һ����¼��Ӧ, �ͻ�׼��ִ�� delete ����
	 * �� OID �����ݱ���û�ж�Ӧ�ļ�¼, ���׳��쳣
	 * 
	 * ����ͨ������ hibernate �����ļ� hibernate.use_identifier_rollback Ϊ true,
	 * ʹɾ�������, ���� OID ��Ϊ  null
	 */
	@Test
	public void testDelete() {
//		User user = new User();
//		user.setId(1);
//		session.delete(user); 
		
		User user = (User) session.get(User.class, 3);
		session.delete(user);
		
		System.out.println(user);
	}
	
	/**
	 * saveOrUpdate:
	 * 	������save��update������������������״̬ʱ����ִ��save�������������ڳ־û�״̬ʱ����ִ��update����
	 * �ж��Ƿ�Ϊ��ʱ״̬��
	 * 	1��Java�����OIDΪnull
	 * 	2�����OID�����ݿ���¼�в����ڣ�����׳��쳣��
	 * 	      ����ӳ���ļ���<id>������unsaved-value���ԣ�����java�����е�oidֵ�����õ�unsaved-valueֵһ��
	 */
	@Test
	public void testSaveOrUpdate() {
//		User user = new User("����", 22, new Date());
//		
//		//user��������״̬��ִ��save
//		session.saveOrUpdate(user);
//		
//		// ִ��save������userת��Ϊ�־û�����
//		user.setAge(45);
//		user.setName("����");
//		
//		session.saveOrUpdate(user);
		
		User user2 = new User("aidai", 10, new Date());
		user2.setId(999);
		session.saveOrUpdate(user2);
	}
	
	/**
	 * update():
	 * 	1) ������һ���־û����󣬲���Ҫ��ʾ����update��������Ϊ�ڵ���Transaction��commit����
	 * 	   ʱ�������session��flush()����
	 * 	
	 * 	2) ������һ�����������Ҫ��ʾ�ĵ���update��������һ���������ת��Ϊ�־û�����
	 * 
	 * 	��Ҫע��ĵط���
	 * 	1������Ҫ���µ������������ݿ���еļ�¼�Ƿ�һ�£��־û�������ȼ�飬��һ�²�ִ��update�����������update
	 * 	       ������������� update��������äĿ�ĳ��� update ����� ? �� .hbm.xml �ļ��� class �ڵ�����
	 *    select-before-update=true (Ĭ��Ϊ false). ������Եĺ�������ÿ��update֮ǰ�Ȳ�ѯһ����
	 *    �ݿ⣬������޸���ִ��update����ͨ������Ҫ���ø�����. 
	 *    
	 *  2�������ݱ���û�ж�Ӧ�ļ�¼, ���������� update ����, ���׳��쳣
	 *  
	 * 	3���� update() ��������һ���������ʱ, 
	 *    ����� Session �Ļ������Ѿ�������ͬ OID �ĳ־û�����, ���׳��쳣. ��Ϊ�� Session ������
	 * 	      ���������� OID ��ͬ�Ķ���!
	*/
	@Test
	public void testUpdate() {
		
		// �־û����󣬲���Ҫ��ʾ����update����
		User user = (User) session.get(User.class, 1);
//		user.setName("�뽿��");
		
//		session.update(user);
		
//		session.clear();
		
		// ����״̬��������ʾ����update����
//		user.setName("���ػ�");
//		session.update(user);
		
		User user2 = (User) session.get(User.class, 1);
		session.update(user); //session ���Ѿ�����user2
	}
	
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
	 * 1) ִ��get()����������ִ�в�ѯ�������ض���getΪ��������
	 *    ִ��load()�������粻ʹ�øö����򲻻�ִ�в�ѯ���������Ƿ���һ���������loadΪ�ӳټ���
	 * 2) ��ʹ��load��ʱ����ʱ�����session�رգ����ܻ��׳�LazyInitializationException�쳣
	 * 3) �����ѯ��oid���ݿ�û�ж�Ӧ�����ݼ�¼������sessionҲû�йر�
	 * 	  	get��������null
	 * 	  	load���������ʹ��ʵ��������ԣ����ز����׳��쳣��ʹ�õ�ʱ����׳��쳣
	 * 		
	 */
	@Test
	public void testLoad() {
		User user = (User) session.load(User.class, 10);
		System.out.println(user.getClass().getName());
		
//		session.close();
		System.out.println(user);
	}
	
	/**
	 * get/load:����һ��oid�������ݿ��м���һ���־û�����session������
	 */
	@Test
	public void testGet() {
		User user = (User) session.get(User.class, 10);
		System.out.println(user.getClass().getName());
//		session.close();
		System.out.println(user);
	}
	
	/**
	 * persist(): ��save����һ�������¼���־û�����
	 * ��save()�������𣺵���һ��OID��Ϊnull�Ķ���ִ��saveʱ����Ѷ�����һ����oid���浽���ݿ��У���persist����׳��쳣
	 */
	@Test
	public void testPersist() {
		User user = new User();
		user.setAge(20);
		user.setDate(new Date());
		user.setName("zhangsan");
		user.setId(10); // �׳��쳣
		
		session.persist(user);
	}
	
	/**
	 * save():���ڽ���ʱ����ת��Ϊ�־û����󣬲����¼
	 * ִ�в��裺1) ʹһ����ʱ���󱣴浽session�����У�ת��Ϊ�־û�����
	 * 		 2) Ϊ�־û���������Ψһ��UID
	 * 		 3) ִ��һ��insert��䣺��flush����ʱ
	 * 		 4) ��save֮ǰ������id����Ч��
	 * 		 5) ��save֮�������id�ǲ��ܱ��޸ĵģ��޸Ļ��׳��쳣
	 */
	@Test
	public void testSave() {
		
		User user = new User();
		user.setAge(20);
		user.setDate(new Date());
		user.setName("zhangsan");
//		user.setId(10); // ����id����Ч��
		
		session.save(user);
		
		System.out.println(user);
		
		user.setId(10); //save()���޸�id���׳��쳣
	}
	
	@After
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
