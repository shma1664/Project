package com.shma.concurrency.chapter03.recipe03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

	public static void main(String[] args) {
		
		int num = 10;
		
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(num);
		
		Player[] players = new Player[num];
		
		for(int i=0; i<num; ++i) {
			players[i] = new Player(i, begin, end);
		}
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(Player player : players) {
			exec.execute(player);
		}
		
		System.out.println("Race begins!");
		
		begin.countDown();
		
		try {
			end.await(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Race ends!");
		}
		
		exec.shutdown();
	}
}
