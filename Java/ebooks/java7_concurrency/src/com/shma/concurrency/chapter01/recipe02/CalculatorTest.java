package com.shma.concurrency.chapter01.recipe02;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() throws IOException {
		System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
		System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
		System.out.printf("Maximum Priority: %s\n", Thread.MAX_PRIORITY);
		
		File file = new File("D:/log.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		PrintWriter pw = new PrintWriter(file);
		
		int num = 10;
		
		Thread[] threads = new Thread[num];
		Thread.State[] states = new Thread.State[num];
		
		for(int i=0; i<num; ++i) {
			Thread thread = new Thread(new Calculator(i+1));
			thread.setName("Thread-" + i);
			threads[i] = thread;
			if(i % 2 == 0) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			states[i] = thread.getState();
			String line = "Main : Status of Thread "+i+" : "+threads[i].getState();
			pw.println(line);
			pw.flush();
		}
		
		for(int i=0; i<num; ++i) {
			threads[i].start();
		}
		
		boolean isFisished = false;
		while(!isFisished) {
			for(int i=0; i<num; ++i) {
				if(threads[i].getState() != states[i]) {
					writeThreadInfo(pw, threads[i], states[i]);
					states[i] = threads[i].getState();
				}
			}
			
			isFisished = true;
			
			for(int i=0; i<num; ++i) {
				isFisished = isFisished && (threads[i].getState() == State.TERMINATED);
				if(!isFisished) {
					break;
				}
 			}
		}
		
		System.out.println("ÔËÐÐ½áÊø");
	}
	
	private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
		pw.println("Main : Id " + thread.getId() + " - " + thread.getName());
		pw.println("Main : Priority: " + thread.getPriority());
		pw.println("Main : Old State: " + state);
		pw.println("Main : New State: " + thread.getState());
		pw.println("Main : ************************************\n");
		pw.flush();
	}

}
