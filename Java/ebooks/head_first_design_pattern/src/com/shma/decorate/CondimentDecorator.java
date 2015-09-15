package com.shma.decorate;

/**
 * ����װ���߳�����
 * ���еľ������϶��󼯳����������
 * ����������ּ�����Beverage������
 * @author admin
 *
 */
public abstract class CondimentDecorator extends Beverage {

	
	protected Beverage beverage;

	/**
	 * ���Ͼ���ʵ������Ҫ��д�����������
	 */
	public abstract String getDescription();
	
}
