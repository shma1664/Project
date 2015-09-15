package test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

import com.shma.Msg;
import com.shma.redis.RedisUtil;
import com.shma.redis.RedisUtil.RedisHash;
import com.shma.util.ObjectUtil;
import com.shma.util.RedPacketAlgorithm;

public class TestRedis {

	protected final static Logger logger = Logger.getLogger("executeLog");
	
	private ApplicationContext context;

	@Before
	public void init() throws Exception {
		String path = "/config/spring-application.xml";
		logger.info(path);
		context = new ClassPathXmlApplicationContext(path);
	}

	@Test
	public void test() {

		final RedisUtil redisUtil = context.getBean(RedisUtil.class);

		long userId = 45243043L;

		int max = 100;
		int min = 2;
		int total = 10000;
		int count = 200;

		//将大红包拆分成小红包数组
		long[] rpDatas = RedPacketAlgorithm.generate(total, count, max, min);

		// 将生成的红包放入队列中
		final String key = "red_packet_original_queue9_" + userId;
		for (int i = 0; i < rpDatas.length; ++i) {
			Msg msg = new Msg();
			msg.setId(i + 1);
			msg.setMoney(rpDatas[i]);
			msg.setSourceUserId(userId);
			logger.info("key : " + key + ", msg : " + msg);
			try {
				redisUtil.lpush(key.getBytes(), ObjectUtil.objectToBytes(msg));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		StopWatch watch = new StopWatch();
		
		logger.info("start:" + System.currentTimeMillis()/1000);
		

		// 已经领取用户列表
		final String mapKey = "map9_" + key;
		
		// 最后生成的领取记录队列
		final String finshKey = "finish9_" + key;
		/**
		 * 接收到一个获取红包请求 判断是否已经领取过 
		 * 如果没有，则从redis队列中取出一个分给该用户 
		 * 添加该用户的领取记录
		 * 如果没有，则返回已经领取完 将完成队列处理入库
		 */
		//模拟300人同时不同的抢红包
		int threadNum = 300;
		final CountDownLatch latch = new CountDownLatch(threadNum);
		watch.start();
		for (int i = 0; i < threadNum; ++i) {
			final int temp = i;
			Thread thread = new Thread() {
				public void run() {
					try {
						String lockKey = key + "_" + temp;
						while(true) {
							
							//加锁60秒
							if(redisUtil.isExistUpdate(lockKey, "60")) {
								RedisHash redisHash = redisUtil.getRedisHash(mapKey);
								
								if(!redisHash.isExist(""+temp)) {
									
									redisHash.setOnlyIfNotExists(temp+"", "1");
									
									try {
										
										logger.info("size:" + redisUtil.getLen(key.getBytes()));
										
										byte[] data = redisUtil.lpop(key.getBytes());
										if(data != null && data.length > 0) {
											Msg msg = (Msg)ObjectUtil.bytesToObject(data);
											msg.setGetUserId(temp);
											logger.info("userid:" + temp + ", msg:" + msg);
											redisUtil.lpush(finshKey.getBytes(), ObjectUtil.objectToBytes(msg));
										} else {
											if(redisUtil.getLen(key.getBytes()) <= 0) {
												logger.info("尊敬的[" + temp +  "]用户，" + "已经领取完了");
												break;
											}
										}
										
										
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								} else {
									logger.info("尊敬的[" + temp +  "]用户，您已经领取过了");
								}
								
								redisUtil.unLockRedisKey(lockKey);
							}
							
							if(redisUtil.getLen(key.getBytes()) <= 0) {
								logger.info("尊敬的[" + temp +  "]用户，" + "已经领取完了");
								break;
							}
						}
					} finally {
						latch.countDown();
					}
					
					
				}
			};
			thread.start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		watch.stop();  
		
		logger.info(redisUtil.getRedisList(key.getBytes()));
		logger.info(redisUtil.getRedisList(finshKey.getBytes()));
		
		List<byte[]> msgs = redisUtil.getRedisList(finshKey.getBytes());
		
		for(byte[] msg : msgs) {
			Msg msgsMsg = null;
			try {
				msgsMsg = (Msg) ObjectUtil.bytesToObject(msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info(msgsMsg);
		}
		
		logger.info("time:" + watch.getTotalTimeSeconds());  
		logger.info("speed:" + total/watch.getTotalTimeSeconds());  
		logger.info("end:" + System.currentTimeMillis()/1000);  


	}

}
