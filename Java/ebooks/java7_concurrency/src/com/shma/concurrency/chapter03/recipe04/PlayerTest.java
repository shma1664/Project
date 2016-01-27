package com.shma.concurrency.chapter03.recipe04;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerTest {

	public static void main(String[] args) {
		
		int num = 5;
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(num, new Runnable() {
			
			@Override
			public void run() {

				System.out.println("恭喜，所有人通过关卡....");
			}
		});
		
		Player[] players = new Player[num];
		
		for(int i=0; i<num; ++i) {
			players[i] = new Player(cyclicBarrier, i+1, num);
		}
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(Player player : players) {
			exec.execute(player);
		}
		
		exec.shutdown();
	}

}
