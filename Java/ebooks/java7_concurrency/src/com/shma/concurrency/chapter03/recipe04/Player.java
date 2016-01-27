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
		
		System.out.printf("玩家%d正在玩第%d关\n", id, level);
		int time = (int) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(time);
			int currNum = cyclicBarrier.getNumberWaiting();
			System.out.printf("玩家%d第%d关通关,当前已有%d个人通关", id, level, currNum);
			if(num == (currNum + 1)) {
				System.out.println("都到齐了,继续下一关");
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
