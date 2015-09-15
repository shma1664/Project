package com.shma.command.remotecontrol;

/**
 * 命令的真正接收者，执行者
 * @author admin
 *
 */
public class Receiver {

	public void action() {
		System.out.println("执行命令...");
	}
	
	public void unAction() {
		System.out.println("撤销命令...");
	}
}
