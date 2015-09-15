package com.shma.concurrency.chapter08;

/**
 * �������ɱ��Ա��������̰߳�ȫ����
 * 	��ע��:1)ImmutableValue��ĳ�Ա����value��ͨ�����캯����ֵ�ģ�����������û��set������
 *  	 2)����ζ��һ��ImmutableValueʵ����������value�����Ͳ����ٱ��޸ģ�����ǲ��ɱ��ԡ�
 *  	 3)�������ͨ��getValue()������ȡ���������ֵ��
 * @author admin
 *
 */
public class ImmutableValue {

	private int value;
	
	public ImmutableValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	/**
	 * �������Ҫ��ImmutableValue���ʵ�����в���������ͨ���õ�value�����󴴽�һ���µ�ʵ����ʵ��
	 * ������һ����value�������мӷ�������ʾ��:
	 * @param newValue
	 * @return
	 */
	public ImmutableValue add(int newValue) {
		return new ImmutableValue(this.value + newValue);
	}
}
