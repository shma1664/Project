package com.shma.jcip.chapter06;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RenderWithTimeBudget {

	/**
	 * Ä¬ÈÏ¹ã¸æ
	 */
	private static final Ad DEFAULT_AD = new Ad(); 
	private static final long TIME_BUDGET = 1000;
	private static final ExecutorService exec = Executors.newCachedThreadPool();
	
	public void renderPageWithAd() {
		long endTime = System.nanoTime();
		Future<Ad> future = exec.submit(new Callable<Ad>() {

			@Override
			public Ad call() throws Exception {
				return new Ad();
			}
			
		});

		Page page = renderPageBody();
		
		Ad ad = null;
		long time = endTime - System.nanoTime() + TIME_BUDGET;
		
		try {
			ad = future.get(time, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
			ad = DEFAULT_AD;
		} catch (ExecutionException e) {
			e.printStackTrace();
			ad = DEFAULT_AD;
		} catch (TimeoutException e) {
			e.printStackTrace();
			ad = DEFAULT_AD;
			future.cancel(true);
			
		}
	}
	
	Page renderPageBody() { return new Page(); }


    static class Ad {
    }

    static class Page {
        public void setAd(Ad ad) { }
    }

    static class FetchAdTask implements Callable<Ad> {
        public Ad call() {
            return new Ad();
        }
    }
}
