package com.shma.command.remotecontrol;

import java.util.ArrayList;
import java.util.Iterator;

public class Client {

	public static void main(String[] args) {
		//����������
		Receiver receiver = new Receiver();
		
		//����������󣬲��������Ľ�����
		Command command = new CreateCommand(receiver);
		
		//���������ߣ�������������ý�ȥ
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		
		invoker.runCommand();
		invoker.unDoCommand();
	}
}
