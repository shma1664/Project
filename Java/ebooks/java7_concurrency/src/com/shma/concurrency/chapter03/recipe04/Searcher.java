package com.shma.concurrency.chapter03.recipe04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {

	private MatrixMock matrixMock;
	
	private Results results;
	
	private int firstRow;
	
	private int lastRow;
	
	private int number;
	
	private final CyclicBarrier cyclicBarrier;

	public Searcher(MatrixMock matrixMock, Results results, int firstRow,
			int lastRow, int number, CyclicBarrier cyclicBarrier) {
		super();
		this.matrixMock = matrixMock;
		this.results = results;
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.number = number;
		this.cyclicBarrier = cyclicBarrier;
	}


	@Override
	public void run() {
		System.out.printf("%s: Processing lines from %d to %d.\n",Thread.currentThread().getName(), firstRow, lastRow);
	
		for(int i=firstRow; i<lastRow; ++i) {
			int counter = 0;
			int[] data = matrixMock.getRow(i);
			for(int value : data) {
				if(value == number) {
					counter++;
				}
			}
			results.setData(i, counter);
		}
		
		System.out.printf("%s: Lines processed.\n",Thread.currentThread().getName());
		
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
