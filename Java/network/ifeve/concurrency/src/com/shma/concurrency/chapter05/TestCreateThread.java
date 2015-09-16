package com.shma.concurrency.chapter05;

/**
 * �����߳�
 * @author admin
 *
 */
public class TestCreateThread {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		/**
		 * �߳�����������ģ�����ִ��������ģ�ִ�����ɲ���ϵͳ��JVM�����ģ�ִ��˳��������˳�򲢷�һ��
		 *  main
			Thread1
			Thread0
			Thread2
			Thread3
			Thread4
			Thread6
			Thread5
			Thread7
			Thread8
			Thread9
		 */
		for(int i=0; i<10; ++i) {
			//�����߳�
			new Thread("Thread" + i) {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
				
			}.start();
		}
	}
}
