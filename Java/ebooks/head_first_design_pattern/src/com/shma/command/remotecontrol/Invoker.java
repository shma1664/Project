package com.shma.command.remotecontrol;

public class Invoker {

	private Command command;
	
	public Invoker() {
		command = new NullCommand();
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void runCommand() {
		command.execute();
	}
	
	public void unDoCommand() {
		command.undo();
	}
}
