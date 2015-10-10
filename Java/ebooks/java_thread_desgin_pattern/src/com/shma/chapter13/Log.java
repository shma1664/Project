package com.shma.chapter13;

public class Log {

	private static final ThreadLocal<PrintLog> THREAD_LOCAL = new ThreadLocal<PrintLog>();
	
	private static PrintLog getPrintLog() {
		PrintLog printLog = THREAD_LOCAL.get();
		if(printLog == null) {
			printLog = new PrintLog(Thread.currentThread().getName() + "_log.txt");
			THREAD_LOCAL.set(printLog);
		}
		
		return printLog;
	}
	
	public static void println(String data) {
		
		PrintLog printLog = getPrintLog();
		printLog.write(data);
	} 
	
	public static void close() {
		PrintLog printLog = getPrintLog();
		printLog.close();
	}
}
