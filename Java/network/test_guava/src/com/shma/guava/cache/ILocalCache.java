package com.shma.guava.cache;

/** 
 * 本地缓存接口 
 * @author shma 
 * 
 * @param <K> Key的类型 
 * @param <V> Value的类型 
 */ 
public interface ILocalCache<K, V> {

	/**
	 * 从缓存中获取数据
	 * @param key
	 * @return
	 */
	public V get(K key);
}
