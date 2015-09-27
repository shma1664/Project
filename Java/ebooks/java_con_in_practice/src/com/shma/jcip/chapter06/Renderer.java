package com.shma.jcip.chapter06;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class Renderer {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
	
	public void renderPage(CharSequence source) {
		List<ImageInfo> imageInfos = scanForImageInfo(source);
		
		CompletionService<ImageData> completionService = new ExecutorCompletionService<Renderer.ImageData>(EXECUTOR_SERVICE);
		
		for(final ImageInfo imageInfo : imageInfos) {
			completionService.submit(new Callable<ImageData>() {
				
				@Override
				public ImageData call() throws Exception {
					return imageInfo.downloadImage();
				}
			});
		}
		
		renderText(source);
		
		for(int i=0; i<imageInfos.size(); ++i) {
			try {
				Future<ImageData> future = completionService.take();
				ImageData imageData = future.get();
				renderImage(imageData);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
}
