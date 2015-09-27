package com.shma.jcip.chapter03;

import com.shma.jcip.annotation.ThreadSafe;

/**
 * 
 *  ��û��ͬ��������£� ���������������Լ�����ʱ�ȶ��п��ܶԲ�����ִ��˳�����һЩ���벻���ĵ�����
 *  	��ȱ���㹻ͬ���Ķ��̳߳����У�Ҫ����ڴ������ִ��˳������жϣ������޷��õ���ȷ�Ľ���
 *  
 *  ��������ֻҪ�������ڶ���߳��й�����ʹ����ȷ��ͬ��
 * @author admin
 *
 */
@ThreadSafe
public class ThreadSafeVisibility {

	private static boolean ready;
	private static int number;
	
	public static void setValue(boolean pReady, int pNumber) {
		synchronized (ThreadSafeVisibility.class) {
			ready = pReady;
			number = pNumber;
		}
	}
	
	public static boolean getReady() {
		synchronized (ThreadSafeVisibility.class) {
			return ready;
		}
	}
	
	public static int getNumber() {
		synchronized (ThreadSafeVisibility.class) {
			return number;
		}
	}
	
	private static class ReaderThread extends Thread {

		@Override
		public void run() {
			while(!getReady()) {
				Thread.yield();
			}
			System.out.println(getNumber());
		}
		
	}
	
	public static void main(String[] args) {
		ReaderThread thread = new ReaderThread();
		thread.start();
		
		setValue(true, 42);
	}
}
