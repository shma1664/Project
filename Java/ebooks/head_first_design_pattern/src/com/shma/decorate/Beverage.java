package com.shma.decorate;

/**
 * ��װ���ߺ�װ���߹����ĳ�����,��װ���ߺ�װ���߶��̳����������
 * @author admin
 *
 */
public abstract class Beverage {

	//��������
	protected String description = "Unknown Beverage";
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * �������ϼ۸�
	 * @return
	 */
	public abstract double cost();
}
