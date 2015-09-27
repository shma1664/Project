package com.shma.jcip.chapter02;

import com.shma.jcip.annotation.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {
	private ExpensiveObject object = null;
	
	public ExpensiveObject getInstance() {
		if(object == null) {
			object = new ExpensiveObject();
		}
		
		return object;
	}
	
}

class ExpensiveObject { }
