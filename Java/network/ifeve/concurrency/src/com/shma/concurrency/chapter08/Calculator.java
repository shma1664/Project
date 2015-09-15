package com.shma.concurrency.chapter08;

/**
 * Calculator�����һ��ָ��ImmutableValueʵ�������á�
 * ע�⣬ͨ��setValue()������add()�������ܻ�ı�������á�
 * ��ˣ���ʹCalculator���ڲ�ʹ����һ�����ɱ���󣬵�Calculator�౾���ǿɱ�ģ����Calculator�಻���̰߳�ȫ�ġ�
 * ���仰˵��ImmutableValue�����̰߳�ȫ�ģ���ʹ�������಻�ǡ�������ͨ�����ɱ���ȥ����̰߳�ȫʱ���������Ҫ�μǵġ�
 * ҪʹCalculator��ʵ���̰߳�ȫ����getValue()��setValue()��add()����������Ϊͬ���������ɡ�
 * @author admin
 *
 */
public class Calculator {

	private ImmutableValue immutableValue;

	public ImmutableValue getImmutableValue() {
		return immutableValue;
	}

	public void setImmutableValue(ImmutableValue immutableValue) {
		this.immutableValue = immutableValue;
	}
	
	public void add(int newValue) {
		this.immutableValue = immutableValue.add(newValue);
	}

}
