package com.shma.jcip.chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class BetterAttributeStore {
	
	private static final Map<String, String> attributes = new HashMap<String, String>();
	
	public boolean userLocationMatches(String name,
            String regexp) {
		String key = "users." + name + ".location";
		String location = null;
		synchronized (this) {
			location = attributes.get(key);
		}
		if(location == null) {
			return false;
		}
		
		return Pattern.matches(regexp, location);
	}
}
