package com.shma.chapter04;

public class TestMain {

	public static void main(String[] args) {
		Person person = new Person("m���ػ�", "m�����ߺ�");
		Person person2 = new Person("q�뽿��", "q�ӱ�����");
		
		new PrintPersonThread("�߳�1", person).start();
		new PrintPersonThread("�߳�2", person2).start();
		new PrintPersonThread("�߳�3", person).start();
		new PrintPersonThread("�߳�4", person2).start();
		new PrintPersonThread("�߳�5", person).start();
		new PrintPersonThread("�߳�6", person2).start();
		new PrintPersonThread("�߳�7", person).start();
	}
}
