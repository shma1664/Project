package com.shma.activemq;

import javax.jms.Message;


/**
 * �ṩ��Ϣ�����Ļص��ӿ�
 * @author linwei
 *
 */
public interface MessageHandler {

	
	/**
	 * ��Ϣ�ص��ṩ�ĵ��÷���
	 * @param message
	 */
	public void handle(Message message);
}

