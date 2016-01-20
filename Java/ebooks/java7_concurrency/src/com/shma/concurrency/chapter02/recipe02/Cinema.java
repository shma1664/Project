package com.shma.concurrency.chapter02.recipe02;

import java.util.concurrent.TimeUnit;

/**
 * µçÓ°Ôº
 * @author shma
 *
 */
public class Cinema {

	private long vacanciesCinema1;
	
	private long vacanciesCinema2;
	
	private final Object vObject1, vObject2;

	public Cinema() {
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
		vObject1 = new Object();
		vObject2 = new Object();
	}
	
	public boolean sellTicket1(int number) {
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (vObject1) {
			if(vacanciesCinema1 > number) {
				vacanciesCinema1 -= number;
				return true;
			} else {
				return false;
			}
			
		}
	}
	
	public boolean sellTicket2(int number) {
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (vObject2) {
			if(vacanciesCinema2 > number) {
				vacanciesCinema2 -= number;
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean returnTicket1(int number) {
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized(vObject1) {
			vacanciesCinema1 += number;
			return true;
		}
	}
	
	public boolean returnTicket2(int number) {
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (vObject2) {
			vacanciesCinema2 += number;
			return true;
		}
	}

	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}
	
	
}
