package com.shma.concurrency.chapter01.recipe04;

import java.io.File;

public class FileSearch implements Runnable {

	private String filePath;
	
	private String searchFileName;

	public FileSearch(String filePath, String searchFileName) {
		super();
		this.filePath = filePath;
		this.searchFileName = searchFileName;
	}

	@Override
	public void run() {
		
		File file = new File(filePath);
		
		if(file.isDirectory()) {
			try {
				dirProcess(file, searchFileName);
			} catch (InterruptedException e) {
				System.out.println("The Prime Generator has been interrupted");
			}
		}
		
	}
	
	private void dirProcess(File file, String searchFileName) throws InterruptedException {
		File[] files = file.listFiles();
		if(files != null) {
			for(File tmpFile : files) {
				if(tmpFile.isDirectory()) {
					dirProcess(tmpFile, searchFileName);
				} else {
					fileProcess(tmpFile, searchFileName);
				}
			}
		}
		
		if(Thread.currentThread().isInterrupted()) {
			throw new InterruptedException();
		}
 	}
	
	private void fileProcess(File file, String searchFileName) throws InterruptedException {
		if(file != null && searchFileName.equals(file.getName())) {
			System.out.println("file path : " + file.getAbsolutePath());
		}
		
		if(Thread.currentThread().isInterrupted()) {
			throw new InterruptedException();
		}
	}

}
