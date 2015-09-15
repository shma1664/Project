package com.shma.state.color;

public class Context {

	private IState state;

	public Context() {
		super();
	}

	public Context(IState state) {
		super();
		this.state = state;
	}
	
	public void push() {
		state.prevState(this);
		System.out.println(state.getState());
	}
	
	public void pull() {
		state.nextState(this);
		System.out.println(state.getState());
	}

	public IState getState() {
		return state;
	}

	public void setState(IState state) {
		this.state = state;
	}
}
