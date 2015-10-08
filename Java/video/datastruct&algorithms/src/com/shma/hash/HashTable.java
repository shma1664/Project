package com.shma.hash;

/**
 * ¡¥µÿ÷∑∑®
 * @author h p
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> {

	private Entry[] arr;
	
	public HashTable(int size) {
		arr = new HashTable.Entry[size];
	}
	
	public int insert(K key, V value) {
		int index = hashCode(key);
		System.out.println(index);
		Entry data = arr[index];
		if(data == null) {
			arr[index] = new Entry(key, value);
			return 1;
		}
		
		Entry parent = null;
		while(data != null) {
			if(data.key.equals(key)) {
				return 0;
			}
			parent = data;
			data = data.nextEntry;
		}
		
		parent.nextEntry = new Entry(key, value);
		return 1;
	}
	
	public int hashCode(K key) {
		return Math.abs(key.hashCode()) % arr.length;
	}

	public boolean find(K key) {
		Entry data = arr[hashCode(key)];
		while(data != null && !data.key.equals(key)) {
			data = data.nextEntry;
		}
		return data == null ? false : true;
	}
	
	public V del(K key) {
		Entry data = arr[hashCode(key)];
		Entry parent = null;
		while(data != null && !data.key.equals(key)) {
			parent = data;
			data = data.nextEntry;
		}
		if(data != null) {
			if(parent == null) {
				arr[hashCode(key)] = data.nextEntry;
			} else {
				parent.nextEntry = data.nextEntry;
			}
			
			return data.value;
		}
		
		return null;
	}
	
	class Entry {
		private K key;
		private V value;
		
		private Entry nextEntry;

		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Entry(K key, V value, Entry nextEntry) {
			super();
			this.key = key;
			this.value = value;
			this.nextEntry = nextEntry;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Entry getNextEntry() {
			return nextEntry;
		}

		public void setNextEntry(Entry nextEntry) {
			this.nextEntry = nextEntry;
		}
	}
}
