package com.shma.jcip.chapter11;

//Ëø·Ö¶Î
public class StripedMap {

	private static final int LOCK_NUM = 16;
	private Node[] nodes;
	private Object[] locks;
	
	public StripedMap(int num) {
		
	}
	
	public static class Node {
		public Object key;
		public Object value;
		public Node next;
	}
	
	public final int hash(Object key) {
		return Math.abs(key.hashCode() % nodes.length);
	}
	
	public Object get(Object key) {
		int hash = hash(key);
		synchronized (locks[hash % LOCK_NUM]) {
			Node first = nodes[hash];
			
			while(first != null) {
				if(first.key.equals(key)) {
					return first.value;
				}
				first = first.next;
			}
		}
		return null;
	}
	
	public void clear() {
		for(int i=0; i<nodes.length; ++i) {
			synchronized (locks[i % LOCK_NUM]) {
				nodes[i] = null;
			}
		}
	}
}
