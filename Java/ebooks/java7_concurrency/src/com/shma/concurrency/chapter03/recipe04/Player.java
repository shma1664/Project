package com.shma.concurrency.chapter03.recipe04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Player implements Runnable {

	private final CyclicBarrier cyclicBarrier;
	private int id;
	private int num;
	
	private static final int MAX_LEVEL = 5;
	
	public Player(CyclicBarrier cyclicBarrier, int id, int num) {
		super();
		this.cyclicBarrier = cyclicBarrier;
		this.id = id;
		this.num = num;
	}

	@Override
	public void run() {
		play(1);
	}
	
	private void play(int level) {
		
		System.out.printf("���%d�������%d��\n", id, level);
		int time = (int) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(time);
			int currNum = cyclicBarrier.getNumberWaiting();
			System.out.printf("���%d��%d��ͨ��,��ǰ����%d����ͨ��", id, level, currNum);
			if(num == (currNum + 1)) {
				System.out.println("��������,������һ��");
			} else {
				System.out.println("");
			}
			cyclicBarrier.await();
			level += 1;
			if(MAX_LEVEL >= level) {
				play(level);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
