package com.shma.state.color;

public class GreenState implements IState {

	@Override
	public void nextState(Context context) {
		context.setState(new BlueState());
	}

	@Override
	public void prevState(Context context) {
		context.setState(new RedState());
	}

	@Override
	public String getState() {
		return "green";
	}

}
