package com.shma.concurrency.chapter02.recipe02;

public class TicketOffice1 implements Runnable {

	private Cinema cinema;
	
	public TicketOffice1(Cinema cinema) {
		this.cinema = cinema;
	}
	
	@Override
	public void run() {
		cinema.sellTicket1(2);
		cinema.sellTicket1(3);
		cinema.sellTicket2(3);
		cinema.sellTicket1(4);
		cinema.sellTicket2(5);
		cinema.returnTicket1(3);
		cinema.returnTicket1(5);
		cinema.returnTicket2(2);
		cinema.returnTicket2(3);
		cinema.sellTicket1(3);
		cinema.sellTicket2(2);
	}

}
