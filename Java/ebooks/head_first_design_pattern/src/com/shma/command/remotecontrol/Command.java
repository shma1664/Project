package com.shma.command.remotecontrol;

/**
 * ����ӿ�
 * @author admin
 *
 */
public interface Command {

	/**
	 * ִ��
	 */
	public void execute();
	
	/**
	 * ����
	 */
	public void undo();
}
