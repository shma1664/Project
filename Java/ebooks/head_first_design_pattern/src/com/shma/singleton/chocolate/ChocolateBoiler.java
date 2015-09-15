package com.shma.singleton.chocolate;

/**
 * �ɿ����ӹ���¯��
 * @author admin
 *
 */
public class ChocolateBoiler {

	//��¼��¯��ԭ���Ƿ�Ϊ��
	private boolean empty = false;
	
	//��¼��¯��ԭ���Ƿ����
	private boolean boiled = false;
	
	private volatile static ChocolateBoiler uniqueInstance = null;
	
	private ChocolateBoiler() {
		
	}
	
	public static ChocolateBoiler getInstance() {
		if(uniqueInstance == null) {
			synchronized (ChocolateBoiler.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new ChocolateBoiler();
				}
			}
		}
		
		System.out.println("Returning instance of Chocolate Boiler");
		return uniqueInstance;
	}
	
	/**
	 * װ����¯
	 * ԭ��Ϊ��
	 */
	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			// fill the boiler with a milk/chocolate mixture
		}
	}
 
	/**
	 * �ų���Ʒ
	 * ԭ�ϲ���Ϊ�ղ����Ѿ������
	 */
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			// drain the boiled milk and chocolate
			empty = true;
		}
	}
 
	/**
	 * ��з���
	 * �����ǹ�¯ԭ�ϲ���Ϊ�ղ���û�б���й�
	 */
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			// bring the contents to a boil
			boiled = true;
		}
	}
  
	public boolean isEmpty() {
		return empty;
	}
 
	public boolean isBoiled() {
		return boiled;
	}
}
