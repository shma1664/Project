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
//		InputStream inputstream = new FileInputStream("D:\\QQ截图20150718132013.png");
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
	 * 调用存储过程
	 */
	@Test
	public void testDoWork() {
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				//调用存储过程
				//com.mchange.v2.c3p0.impl.NewProxyConnection@7f5338bf
				System.out.println(conn);
			}
		});
	}
	
	/**
	 * evict()：从缓存中移除指定的持久化对象
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
	 * delete: 执行删除操作. 只要 OID 和数据表中一条记录对应, 就会准备执行 delete 操作
	 * 若 OID 在数据表中没有对应的记录, 则抛出异常
	 * 
	 * 可以通过设置 hibernate 配置文件 hibernate.use_identifier_rollback 为 true,
	 * 使删除对象后, 把其 OID 置为  null
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
	 * 	包含了save和update方法，当对象处于游离状态时，则执行save操作，当对象处于持久化状态时，则执行update操作
	 * 判断是否为临时状态：
	 * 	1、Java对象的OID为null
	 * 	2、如果OID在数据库表记录中不存在，则会抛出异常，
	 * 	      除非映射文件中<id>设置了unsaved-value属性，并且java对象中的oid值与设置的unsaved-value值一致
	 */
	@Test
	public void testSaveOrUpdate() {
//		User user = new User("王二", 22, new Date());
//		
//		//user处于游离状态，执行save
//		session.saveOrUpdate(user);
//		
//		// 执行save操作后user转变为持久化对象
//		user.setAge(45);
//		user.setName("王五");
//		
//		session.saveOrUpdate(user);
		
		User user2 = new User("aidai", 10, new Date());
		user2.setId(999);
		session.saveOrUpdate(user2);
	}
	
	/**
	 * update():
	 * 	1) 若更新一个持久化对象，不需要显示调用update方法，因为在调用Transaction的commit方法
	 * 	   时，会调用session的flush()方法
	 * 	
	 * 	2) 若更新一个游离对象，需要显示的调用update方法，把一个游离对象转换为持久化对象
	 * 
	 * 	需要注意的地方：
	 * 	1、无论要更新的游离对象和数据库表中的记录是否一致（持久化对象会先检查，不一致才执行update），都会调用update
	 * 	       操作，如何能让 update方法不再盲目的出发 update 语句呢 ? 在 .hbm.xml 文件的 class 节点设置
	 *    select-before-update=true (默认为 false). 这个属性的含义是在每次update之前先查询一遍数
	 *    据库，如果有修改在执行update，但通常不需要设置该属性. 
	 *    
	 *  2、若数据表中没有对应的记录, 但还调用了 update 方法, 会抛出异常
	 *  
	 * 	3、当 update() 方法关联一个游离对象时, 
	 *    如果在 Session 的缓存中已经存在相同 OID 的持久化对象, 会抛出异常. 因为在 Session 缓存中
	 * 	      不能有两个 OID 相同的对象!
	*/
	@Test
	public void testUpdate() {
		
		// 持久化对象，不需要显示调用update方法
		User user = (User) session.get(User.class, 1);
//		user.setName("齐娇娇");
		
//		session.update(user);
		
//		session.clear();
		
		// 游离状态，必须显示调用update方法
//		user.setName("马韶华");
//		session.update(user);
		
		User user2 = (User) session.get(User.class, 1);
		session.update(user); //session 中已经存在user2
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
	 * 1) 执行get()方法：立即执行查询操作加载对象，get为立即检索
	 *    执行load()方法：如不使用该对象，则不会执行查询操作，而是返回一个代理对象，load为延迟检索
	 * 2) 当使用load延时检索时，如果session关闭，可能会抛出LazyInitializationException异常
	 * 3) 如果查询的oid数据库没有对应的数据记录，并且session也没有关闭
	 * 	  	get方法返回null
	 * 	  	load方法如果不使用实体对象属性，加载不会抛出异常，使用的时候会抛出异常
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
	 * get/load:根据一个oid，从数据库中加载一个持久化对象到session缓存中
	 */
	@Test
	public void testGet() {
		User user = (User) session.get(User.class, 10);
		System.out.println(user.getClass().getName());
//		session.close();
		System.out.println(user);
	}
	
	/**
	 * persist(): 和save方法一样保存记录到持久化对象
	 * 和save()方法区别：当对一个OID不为null的对象执行save时，会把对象以一个新oid保存到数据库中，而persist则会抛出异常
	 */
	@Test
	public void testPersist() {
		User user = new User();
		user.setAge(20);
		user.setDate(new Date());
		user.setName("zhangsan");
		user.setId(10); // 抛出异常
		
		session.persist(user);
	}
	
	/**
	 * save():用于将临时对象转换为持久化对象，插入记录
	 * 执行步骤：1) 使一个临时对象保存到session缓存中，转换为持久化对象
	 * 		 2) 为持久化对象生成唯一的UID
	 * 		 3) 执行一条insert语句：在flush缓存时
	 * 		 4) 在save之前的设置id是无效的
	 * 		 5) 在save之后的设置id是不能被修改的，修改会抛出异常
	 */
	@Test
	public void testSave() {
		
		User user = new User();
		user.setAge(20);
		user.setDate(new Date());
		user.setName("zhangsan");
//		user.setId(10); // 设置id是无效的
		
		session.save(user);
		
		System.out.println(user);
		
		user.setId(10); //save()后修改id，抛出异常
	}
	
	@After
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
