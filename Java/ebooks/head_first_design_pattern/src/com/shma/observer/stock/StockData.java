package com.shma.observer.stock;

import java.util.Observable;

public class StockData extends Observable {

	public StockData() {
		
	}
	
	public void sendStockData(StockEntity entity)  {  
		setChanged();  
		notifyObservers(entity);  
    }
	
	public void setStockData(String symbol,float close,float high,float low,long volume) {  
		StockEntity entity = new StockEntity(symbol, close, high, low, volume);  
		sendStockData(entity);  
    }  
	
}
