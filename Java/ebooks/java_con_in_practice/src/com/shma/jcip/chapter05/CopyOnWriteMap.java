package com.shma.jcip.chapter05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author admin
 *
 * @param <K>
 * @param <V>
 */
public class CopyOnWriteMap<K, V> implements Map<K, V> {

	private volatile Map<K, V> internalMap;
	
	public CopyOnWriteMap() {
		internalMap = new HashMap<K, V>();
	}
	
	@Override
	public void clear() {
		internalMap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}

	@Override
	public V get(Object key) {
		return internalMap.get(key);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		synchronized (this) {
			Map<K, V> newMap = new HashMap<K, V>(internalMap);
			
			V val = newMap.put(key, value);
			internalMap = newMap;
			
			return val;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		
		synchronized (this) {
			
			Map<K, V> newMap = new HashMap<K, V>(internalMap);
			newMap.putAll(m);
			
			internalMap = newMap;
		}
		
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
