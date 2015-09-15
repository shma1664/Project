package com.shma.threadlocal;

public class TestNum {

	private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			return 0;
		}
		
	};
	
	public static void main(String[] args) {
		TestNum sn = new TestNum();
		new TestClient(sn).start();
		new TestClient(sn).start();
		new TestClient(sn).start();

	}
	
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	
	
}

class TestClient extends Thread {

	private TestNum sn;
	
	public TestClient(TestNum sn) {
		this.sn = sn;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; ++i) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["+ sn.getNextNum() + "]");  

		}
	}

}
