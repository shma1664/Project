package com.shma.activemq;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * ˵���� activemq send message
 * 
 * @author xajava
 * @version ����ʱ�䣺2012-10-24 ����1:22:40
 */
public class JmsSender {

	private String USER = ActiveMQConnection.DEFAULT_USER;
	private String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private String SUBJECT = "ActiveMQ.Demo";

	private Destination destination = null;
	private Connection conn = null;
	private Session session = null;
	private MessageProducer producer = null;

	// ��ʼ��
	private void initialize() throws JMSException, Exception {
		// ���ӹ���
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		conn = connectionFactory.createConnection();
		// �����ԻỰ���Զ�ȷ����Ϣ
		session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// ��Ϣ��Ŀ�ĵأ�Queue/Topic��
		destination = session.createQueue(SUBJECT);
		// destination = session.createTopic(SUBJECT);
		// ��Ϣ���ṩ�ߣ������ߣ�
		producer = session.createProducer(destination);
		// ���־û���Ϣ
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	}

	public void sendMessage(String msgType) throws JMSException, Exception {
		initialize();
		// ���ӵ�JMS�ṩ�ߣ���������
		conn.start();
		// �����ı���Ϣ
		if ("text".equals(msgType)) {
			String textMsg = "ActiveMQ Text Message!";
			TextMessage msg = session.createTextMessage();
			// TextMessage msg = session.createTextMessage(textMsg);
			msg.setText(textMsg);
			producer.send(msg);
		}
		// ����Map��Ϣ
		if ("map".equals(msgType)) {
			MapMessage msg = session.createMapMessage();
			msg.setBoolean("boolean", true);
			msg.setShort("short", (short) 0);
			msg.setLong("long", 123456);
			msg.setString("MapMessage", "ActiveMQ Map Message!");
			producer.send(msg);
		}
		// ��������Ϣ
		if ("stream".equals(msgType)) {
			String streamValue = "ActiveMQ stream Message!";
			StreamMessage msg = session.createStreamMessage();
			msg.writeString(streamValue);
			msg.writeBoolean(false);
			msg.writeLong(1234567890);
			producer.send(msg);
		}
		// ���Ͷ�����Ϣ
		if ("object".equals(msgType)) {
			JmsObjectMessageBean jmsObject = new JmsObjectMessageBean(
					"ActiveMQ Object Message", 18, false);
			ObjectMessage msg = session.createObjectMessage();
			msg.setObject(jmsObject);
			producer.send(msg);
		}
		// �����ֽ���Ϣ
		if ("bytes".equals(msgType)) {
			String byteValue = "�ֽ���Ϣ";
			BytesMessage msg = session.createBytesMessage();
			msg.writeBytes(byteValue.getBytes());
			producer.send(msg);
		}
	}

	// �ر�����
	public void close() throws JMSException {
		if (producer != null)
			producer.close();
		if (session != null)
			session.close();
		if (conn != null)
			conn.close();
	}

}
