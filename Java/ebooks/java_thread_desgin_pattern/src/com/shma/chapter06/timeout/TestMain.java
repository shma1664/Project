package com.shma.chapter06.timeout;

public class TestMain {

	public static void main(String[] args) {
		Host host = new Host(10000);
		
		System.out.println("execute begin///");
		
		try {
			host.execute();
		} catch (TimeoutException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
