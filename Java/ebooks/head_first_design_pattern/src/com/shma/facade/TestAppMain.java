package com.shma.facade;

public class TestAppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Behavior cpuBehavior = new Cpu();
		Behavior memoryBehavior = new Memory();
		Behavior diskBehavior = new Disk();
		
		ComputerFacade facade = new ComputerFacade(cpuBehavior, memoryBehavior, diskBehavior);
		facade.startup();
		
		facade.shutdown();
	}

}
