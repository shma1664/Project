package com.shma.state.color;

public class RedState implements IState {

	@Override
	public void nextState(Context context) {
		context.setState(new GreenState());
	}

	@Override
	public void prevState(Context context) {
		context.setState(new BlueState());
	}

	@Override
	public String getState() {
		return "red";
	}

}
