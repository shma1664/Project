package com.shma.jcip.chapter08;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.shma.jcip.annotation.NotThreadSafe;

/**
 * œﬂ≥ÃÀ¿À¯
 * @author admin
 *
 */
@NotThreadSafe
public class ThreadDeadlock {

	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	public class LocalFileTask implements Callable<String> {

		private final String fileName;
		
		public LocalFileTask(String fileName) {
			this.fileName = fileName;
		}
		
		@Override
		public String call() throws Exception {
			return null;
		}
		
	}
	
	public class RenderPageTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			Future<String> header = exec.submit(new LocalFileTask("header.html"));
			Future<String> footer = exec.submit(new LocalFileTask("footer.html"));
			String page = renderBody();
			return header.get() + page + footer.get();
		}
		
		private String renderBody() {
          	Runtime.getRuntime().availableProcessors();
            return "";
        }
		
	}
}
