package com.shma.jcip.chapter03;

import com.shma.jcip.annotation.NotThreadSafe;

/**
 * ���̰߳�ȫ��
 * ������������
 * 	1) �������42
 * 	2) ���0�����߳�ֻ������readyֵ��û�п���numberֵ
 * 	3) ��ѭ�������߳���Զ������readyֵ
 * 
 *  ���ۣ���û��ͬ��������£� ���������������Լ�����ʱ�ȶ��п��ܶԲ�����ִ��˳�����һЩ���벻���ĵ�����
 *  	��ȱ���㹻ͬ���Ķ��̳߳����У�Ҫ����ڴ������ִ��˳������жϣ������޷��õ���ȷ�Ľ���
 *  
 *  ��������ֻҪ�������ڶ���߳��й�����ʹ����ȷ��ͬ��
 * @author admin
 *
 */
@NotThreadSafe
public class NoVisibility {

	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread {

		@Override
		public void run() {
			while(!ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
		
	}
	
	public static void main(String[] args) {
		ReaderThread thread = new ReaderThread();
		thread.start();
		
		number = 42;
		ready = true;
	}
}
