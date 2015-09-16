package com.shma.jcip.chapter06;

import java.util.List;

public abstract class SingleThreadRenderer {

	abstract void renderText(CharSequence s);
	
    abstract List<ImageInfo> scanForImageInfo(CharSequence s);
    
    abstract void renderImage(ImageData i);
    
    public void renderPage(CharSequence source) {
    	renderText(source);
    	
    	for(ImageInfo imageInfo : scanForImageInfo(source)) {
    		renderImage(imageInfo.downloadImage());
    	}
    }

    interface ImageData {
    	
    }

    interface ImageInfo {
    	
        ImageData downloadImage();
        
    }
}


