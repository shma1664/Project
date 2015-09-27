package com.shma.jcip.chapter03;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class SafeListener {

	private final EventListener listener;
	
	private SafeListener() {
		listener = new EventListener() {
			
			@Override
			public void onEvent(Event e) {
				doSomething(e);
				
			}
		};
	}
	
	void doSomething(Event e) {
    }
	
	public static SafeListener newInstance(EventSource source) {
		SafeListener safeListener = new SafeListener();
		source.registerListener(safeListener.listener);
		
		return safeListener;
	}
	
	interface EventSource {
	    void registerListener(EventListener e);
	}

	interface EventListener {
	    void onEvent(Event e);
	}

	interface Event {
	}
}
