package com.shma.activemq;

import javax.jms.JMSException;

/**
 * ˵����
 * 
 * @author xajava
 * @version ����ʱ�䣺2012-10-22 ����4:33:17
 */
public class Test {

	public static void main(String[] args) throws JMSException, Exception {
		JmsSender sender = new JmsSender();
		JmsReceiver receiver = new JmsReceiver();

		sender.sendMessage("bytes");
		sender.close();

		receiver.receiveMessage();
		receiver.close();

	}
}
