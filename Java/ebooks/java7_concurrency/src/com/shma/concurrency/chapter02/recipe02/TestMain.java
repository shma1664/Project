package com.shma.concurrency.chapter02.recipe02;

import org.junit.Test;

public class TestMain {

	@Test
	public void test() {
		Cinema cinema = new Cinema();
		
		System.out.println("Begin ticket number:" + cinema.getVacanciesCinema1() + ", " + cinema.getVacanciesCinema2());

		
		Thread ticketOffice1 = new Thread(new TicketOffice1(cinema));
		Thread ticketOffice2 = new Thread(new TicketOffice2(cinema));
		
		ticketOffice1.start();
		ticketOffice2.start();
		
		try {
			ticketOffice1.join();
			ticketOffice2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished ticket number:" + cinema.getVacanciesCinema1() + ", " + cinema.getVacanciesCinema2());
	}
}
