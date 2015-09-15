package com.shma.activemq;

import java.util.Enumeration;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * ˵����
 * 
 * @author xajava
 * @version ����ʱ�䣺2012-10-24 ����2:06:48
 */
public class JmsReceiver implements MessageListener {

	private String USER = ActiveMQConnection.DEFAULT_USER;
	private String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private String SUBJECT = "ActiveMQ.Demo";

	private Destination dest = null;
	private Connection conn = null;
	private Session session = null;
	private MessageConsumer consumer = null;

	private boolean stop = false;

	// ��ʼ��
	private void initialize() throws JMSException, Exception {
		// ���ӹ������û��������ӵĶ���.
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		// ���ӹ�������һ��jms connection
		conn = connectionFactory.createConnection();
		// �����������ѵ�һ�����߳������ġ��Ự���ڴ�����Ϣ�������ߣ������ߺ���Ϣ���Ự�ṩ��һ�������Ե������ġ�
		session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE); // ��֧������
		// Ŀ�ĵ��ǿͻ�����ָ����������Ϣ��Ŀ�껹����������Ϣ����Դ�Ķ���.
		dest = session.createQueue(SUBJECT);
		// dest = session.createTopic(SUBJECT);
		// �Ự������Ϣ�������߽���Ϣ���͵�Ŀ�ĵ�
		consumer = session.createConsumer(dest);
	}

	/**
	 * ������Ϣ
	 * 
	 * @throws JMSException
	 * @throws Exception
	 */
	public void receiveMessage() throws JMSException, Exception {
		initialize();
		conn.start();
		consumer.setMessageListener(this);
		// �ȴ�������Ϣ
		while (!stop) {
			Thread.sleep(5000);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void onMessage(Message msg) {
		try {
			if (msg instanceof TextMessage) {
				TextMessage message = (TextMessage) msg;
				System.out.println("------Received TextMessage------");
				System.out.println(message.getText());
			} else if (msg instanceof MapMessage) {
				MapMessage message = (MapMessage) msg;
				System.out.println("------Received MapMessage------");
				System.out.println(message.getLong("long"));
				System.out.println(message.getBoolean("boolean"));
				System.out.println(message.getShort("short"));
				System.out.println(message.getString("MapMessage"));
				System.out.println("------Received MapMessage for while------");
				Enumeration enumer = message.getMapNames();
				while (enumer.hasMoreElements()) {
					Object obj = enumer.nextElement();
					System.out.println(message.getObject(obj.toString()));
				}
			} else if (msg instanceof StreamMessage) {
				StreamMessage message = (StreamMessage) msg;
				System.out.println("------Received StreamMessage------");
				System.out.println(message.readString());
				System.out.println(message.readBoolean());
				System.out.println(message.readLong());
			} else if (msg instanceof ObjectMessage) {
				System.out.println("------Received ObjectMessage------");
				ObjectMessage message = (ObjectMessage) msg;
				JmsObjectMessageBean jmsObject = (JmsObjectMessageBean) message
						.getObject();
				System.out.println(jmsObject.getUserName() + "__"
						+ jmsObject.getAge() + "__" + jmsObject.isFlag());
			} else if (msg instanceof BytesMessage) {
				System.out.println("------Received BytesMessage------");
				BytesMessage message = (BytesMessage) msg;
				byte[] byteContent = new byte[1024];
				int length = -1;
				StringBuffer content = new StringBuffer();
				while ((length = message.readBytes(byteContent)) != -1) {
					content.append(new String(byteContent, 0, length));
				}
				System.out.println(content.toString());
			} else {
				System.out.println(msg);
			}
			stop = true;
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				this.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	// �ر�����
	public void close() throws JMSException {
		System.out.println("Consumer:->Closing connection");
		if (consumer != null)
			consumer.close();
		if (session != null)
			session.close();
		if (conn != null)
			conn.close();
	}
}
