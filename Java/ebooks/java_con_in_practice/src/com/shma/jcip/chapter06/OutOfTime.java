package com.shma.jcip.chapter06;

import java.util.Timer;
import java.util.TimerTask;

public class OutOfTime {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.schedule(new ThrowTask(), 1L);
		
		Thread.sleep(1);
		
		timer.schedule(new ThrowTask(), 5);
		Thread.sleep(5);
	}
}

class ThrowTask extends TimerTask {

	@Override
	public void run() {
		throw new RuntimeException();
	}
	
}
