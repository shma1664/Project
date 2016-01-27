package com.shma.concurrency.chapter03.recipe04;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

	public static void main(String[] args) {
		final int ROWS= 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5; 
		final int PARTICIPANTS = 10;
		
		MatrixMock matrixMock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		
		Results results = new Results(ROWS);
		
		Grouper grouper = new Grouper(results);
		
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTICIPANTS, grouper);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		
		int pageSize = ROWS / PARTICIPANTS;
		for(int i=0; i<10; ++i) {
			int firstRow = i * pageSize;
			int lastRow = (i + 1) * pageSize;
			
			Searcher searcher = new Searcher(matrixMock, results, firstRow, lastRow, SEARCH, cyclicBarrier);
			exec.execute(searcher);
		}
		
		exec.shutdown();
		System.out.printf("Main: The main thread has finished.\n");
	}
}
