package com.shma.chapter04;

public class PrintPersonThread extends Thread {
	
	private Person person;

	public PrintPersonThread(String threadName, Person person) {
		super(threadName);
		this.person = person;
	}

	@Override
	public void run() {
		while(true) {
			if(person.getName().charAt(0) != person.getAddress().charAt(0)) {
				System.out.println(Thread.currentThread().getName() + " : " + person);
			}
			
		}
	}

}
