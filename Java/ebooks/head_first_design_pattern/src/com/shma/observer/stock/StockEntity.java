package com.shma.observer.stock;

public class StockEntity {

	private String symbol;  
    private float close;  
    private float high;  
    private float low;  
    private long volume;
 
	public StockEntity(String symbol, float close, float high, float low,
			long volume) {
		super();
		this.symbol = symbol;
		this.close = close;
		this.high = high;
		this.low = low;
		this.volume = volume;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	} 
}
