package com.shma.concurrency.chapter04.recipe11;

import java.io.File;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletionServiceDemo {

	private static ExecutorService executorService = Executors.newCachedThreadPool();
	
	private static CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
	
	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);
	
	public void coutLines() {
		String path = "E:/code/Project/qiqi_mobile/src";
		File file = new File(path);
		
		statusCount(file);
		int count = 0;
		for(int i=0; i<ATOMIC_INTEGER.get(); ++i) {
			try {
				Future<Integer> future = completionService.take();
				count += future.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("%s 目录文件总行数为：%d\n", path, count);
		executorService.shutdown();
	}
	
	public void statusCount(File file) {
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File tmpFile : files) {
				statusCount(tmpFile);
			}
		} else {
			FileCountLine fileCountLine = new FileCountLine(file);
			ATOMIC_INTEGER.incrementAndGet();
			completionService.submit(fileCountLine);
		}
	}
	
	public static void main(String[] args) {
		CompletionServiceDemo demo = new CompletionServiceDemo();
		demo.coutLines();
	}
}
