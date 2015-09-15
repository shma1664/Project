package com.shma.state.color;

public class TestMainApp {

	public static void main(String[] args) {
		Context context = new Context();
		IState state = new RedState();
		context.setState(state);
		while(true) {
			System.out.println("��ǰ״̬Ϊ��" + context.getState().getState());
			System.out.print("��һ��״̬��");
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
