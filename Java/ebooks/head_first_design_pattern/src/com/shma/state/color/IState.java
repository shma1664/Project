package com.shma.state.color;

public interface IState {

	public void nextState(Context context);
	
	public void prevState(Context context);
	
	public String getState();
}
