package com.shma.jcip.chapter03;

import com.shma.jcip.annotation.NotThreadSafe;

@NotThreadSafe
public class NotSafeListener {

	public NotSafeListener(EventSource source) {
		source.registerListener(new EventListener() {	
			@Override
			public void onEvent(Event e) {
				doSomething(e);
			}
		});
	}
	
	void doSomething(Event e) {
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
