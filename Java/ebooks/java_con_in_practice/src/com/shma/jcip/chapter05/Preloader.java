package com.shma.jcip.chapter05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {

	private final FutureTask<ProductInfo> FUTURE_TASK = new FutureTask<ProductInfo>(
			new Callable<ProductInfo>() {

				@Override
				public ProductInfo call() throws Exception {
					return loadProductInfo();
				}

			});
	
	private final Thread thread = new Thread(FUTURE_TASK);
	
	private ProductInfo loadProductInfo() {
		return null;
	}
	
	public void start() {
		thread.start();
	}
	
	public ProductInfo get() throws InterruptedException, DataLoadException {
		try {
			return FUTURE_TASK.get();
		} catch (ExecutionException e) {
			e.printStackTrace();
			Throwable throwable = e.getCause();
			if(throwable instanceof DataLoadException) {
				throw (DataLoadException)throwable;
			} else {
				throw launderThrowable(throwable);
			}
		}
	}

	private RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException)
            return (RuntimeException) t;
        else if (t instanceof Error)
            throw (Error) t;
        else
            throw new IllegalStateException("Not unchecked", t);
	}

}

class DataLoadException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
}

class ProductInfo {

}
