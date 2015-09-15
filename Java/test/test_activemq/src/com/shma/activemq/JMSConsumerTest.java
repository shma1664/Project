package com.shma.activemq;

import javax.jms.MapMessage;
import javax.jms.Message;

public class JMSConsumerTest {

	
	public static void main(String[] args) throws Exception {
		
		//**  JMSConsumer �������ó�ȫ�ֵľ�̬������ֻ��ʵ����һ�μ���ʹ��,��ֹѭ���ظ�ʵ����JMSConsumer(��Ϊ���ڲ�����һ���̳߳�)

		JMSConsumer consumer = new JMSConsumer();
		consumer.setBrokerUrl("tcp://localhost:61616");
		consumer.setQueue("test");
		consumer.setUserName("system");
		consumer.setPassword("manager");
		consumer.setQueuePrefetch(500);
		consumer.setMessageListener(new MultiThreadMessageListener(50,new MessageHandler() {
			public void handle(Message message) {
				try {
					System.out.println("name is " + ((MapMessage)message).getString("name"));
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}));
		consumer.start();
		
//		Thread.sleep(5000);
//		consumer.shutdown();
		
	}
	
	
}

