package com.shma.jcip.chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class FutureRender {

	private static final ExecutorService exec = Executors.newCachedThreadPool();
	
	public void renderPage(CharSequence source) {
		final List<ImageInfo> imageInfos = scanForImageInfo(source);
		
		Callable<List<ImageData>> task = new Callable<List<ImageData>>() {

			@Override
			public List<ImageData> call() throws Exception {
				List<ImageData> result = new ArrayList<ImageData>();
				for(ImageInfo imageInfo : imageInfos) {
					result.add(imageInfo.downloadImage());
				}
				return result;
			}
		};
		
		Future<List<ImageData>> future = exec.submit(task);
		
		renderText(source);
		
		try {
			List<ImageData> imageDatas = future.get();
			for(ImageData imageData : imageDatas) {
				renderImage(imageData);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
			future.cancel(true);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	abstract void renderText(CharSequence s);
	
    abstract List<ImageInfo> scanForImageInfo(CharSequence s);
    
    abstract void renderImage(ImageData i);
	
	interface ImageData {
    	
    }

    interface ImageInfo {
    	
        ImageData downloadImage();
        
    }
}
