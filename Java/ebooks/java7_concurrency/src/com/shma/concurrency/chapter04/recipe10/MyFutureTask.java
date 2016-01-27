package com.shma.concurrency.chapter04.recipe10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyFutureTask extends FutureTask<String> {

	public MyFutureTask(Callable<String> paramCallable) {
		super(paramCallable);
	}

	@Override
	protected void done() {
		try {
			System.out.printf("执行完毕，结果集为：%s\n", this.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
