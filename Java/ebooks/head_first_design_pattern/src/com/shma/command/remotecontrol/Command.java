package com.shma.command.remotecontrol;

/**
 * 命令接口
 * @author admin
 *
 */
public interface Command {

	/**
	 * 执行
	 */
	public void execute();
	
	/**
	 * 撤销
	 */
	public void undo();
}
