package com.shma.state.color;

public class TestMainApp {

	public static void main(String[] args) {
		Context context = new Context();
		IState state = new RedState();
		context.setState(state);
		while(true) {
			System.out.println("当前状态为：" + context.getState().getState());
			System.out.print("上一个状态：");
			context.push();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
