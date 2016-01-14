package com.shma.concurrency.chapter01.recipe11;

public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String paramString) {
		super(paramString);
	}

	public MyThreadGroup(ThreadGroup paramThreadGroup, String paramString) {
		super(paramThreadGroup, paramString);

	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// Prints the name of the Thread
		System.out.printf("The thread %s has thrown an Exception\n",t.getId());
		// Print the stack trace of the exception
		e.printStackTrace(System.out);
		// Interrupt the rest of the threads of the thread group
		System.out.printf("Terminating the rest of the Threads\n");
		interrupt();
	}

}
