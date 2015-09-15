package com.shma.state.color;

public class BlueState implements IState {

	@Override
	public void nextState(Context context) {
		context.setState(new RedState());
	}

	@Override
	public void prevState(Context context) {
		context.setState(new GreenState());
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return "blue";
	}

}
