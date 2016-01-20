package com.shma.concurrency.chapter02.recipe02;

public class TicketOffice2 implements Runnable {

	private Cinema cinema;
	
	public TicketOffice2(Cinema cinema) {
		this.cinema = cinema;
	}
	
	@Override
	public void run() {
		cinema.sellTicket1(1);
		cinema.sellTicket1(2);
		cinema.sellTicket2(1);
		cinema.sellTicket1(3);
		cinema.sellTicket2(2);
		cinema.returnTicket1(2);
		cinema.returnTicket1(1);
		cinema.returnTicket2(3);
		cinema.returnTicket2(2);
		cinema.sellTicket1(2);
		cinema.sellTicket2(2);
	}

}
