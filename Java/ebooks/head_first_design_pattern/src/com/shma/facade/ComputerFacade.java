package com.shma.facade;

/**
 * 电脑外观,整合cpu、memory、disk方法
 * @author admin
 *
 */
public class ComputerFacade {

	private Behavior cpuBehavior;
	private Behavior memoryBehavior;
	private Behavior diskBehavior;
	
	public ComputerFacade(Behavior cpuBehavior, Behavior memoryBehavior, Behavior diskBehavior) {
		this.cpuBehavior = cpuBehavior;
		this.memoryBehavior = memoryBehavior;
		this.diskBehavior = diskBehavior;
	}
	
	public void startup() {
		cpuBehavior.startup();
		memoryBehavior.startup();
		diskBehavior.startup();
	}
	
	public void shutdown() {
		cpuBehavior.shutdown();
		memoryBehavior.shutdown();
		diskBehavior.shutdown();
	}
	
}
