package com.shma.activemq;


import java.util.HashMap;
import java.util.Map;

public class JMSProducerTest {

	
	public static void main(String[] args) {
		locationTest();
		System.out.println("over.");
	}

	
	public static void locationTest() {
		//**  JMSProducer �������ó�ȫ�ֵľ�̬������ֻ��ʵ����һ�μ���ʹ��,��ֹѭ���ظ�ʵ����JMSProducer(��Ϊ���ڲ�����һ���̳߳�)
		
		//֧��openwireЭ���Ĭ������Ϊ tcp://localhost:61616��֧�� stompЭ���Ĭ������Ϊtcp://localhost:61613�� 
		//tcp��nio������
		//nio://localhost:61617 �Լ� tcp://localhost:61616������ activemq.xml�����ļ��н�������
		JMSProducer producer = new JMSProducer("nio://localhost:61617", "admin", "admin");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "1");
		map.put("name", "sss1113333");
		map.put("password", "password");
		producer.send("test", map);
	}
	
}

