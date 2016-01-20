package com.shma.concurrency.chapter02.recipe03;

import java.util.List;

import com.google.common.collect.Lists;

public class Basket {

	private int maxSize;
	
	private List<WoTou> dataList = null;

	public Basket(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.dataList = Lists.newArrayList();
	}
	
	public void put(WoTou woTou) {
		synchronized(this) {
			while(dataList.size() >= maxSize) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			dataList.add(woTou);
			System.out.println("添加了一个窝头：" + woTou + ", size:" + dataList.size());
			notifyAll();
		}
	}
	
	public WoTou take() {
		synchronized (this) {
			while(dataList.size() == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			WoTou woTou = dataList.remove(0);
			System.out.println("消费了一个窝头：" + woTou + ", size:" + dataList.size());
			notifyAll();
			
			return woTou;
		}
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public List<WoTou> getDataList() {
		return dataList;
	}
}
