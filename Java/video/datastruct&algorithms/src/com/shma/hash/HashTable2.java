package com.shma.hash;

/**
 * ���ŵ�ַ��
 * @author h p
 *
 * @param <K>
 * @param <V>
 */
public class HashTable2<K, V> {

	private Entry[] arr;
	
	public HashTable2(int size) {
		arr = new HashTable2.Entry[size];
	}
	
	public int insert(K key, V value) {
		int index = hashCode(key);
		int startIndex = index;
		System.out.println(index);
		while(arr[index] != null && arr[index].value != null) {
			
			if(arr[index].key.equals(key)) {
				return 0;
			}
			
			index = (index + 1) % arr.length;
			if(index == startIndex) {
				//ѭ��һ�Σ�����
				throw new ArrayFullException("��������");
			}
		}
		
		arr[index] = new Entry(key, value);
		return 1;
	}
	
	public int hashCode(K key) {
		return Math.abs(key.hashCode()) % arr.length;
	}

	public boolean find(K key) {
		int index = hashCode(key);
		int startIndex = index;
		System.out.println(index);
		while(arr[index] != null && arr[index].value != null) {
			
			if(arr[index].key.equals(key)) {
				return true;
			}
			
			index = (index + 1) % arr.length;
			
			if(index == startIndex) {
				return false;
			}
		}
		
		return false;
		
	}
	
	public V delete(K key) {
		int index = hashCode(key);
		int startIndex = index;
		System.out.println(index);
		while(arr[index] != null && arr[index].value != null) {
			
			if(arr[index].key.equals(key)) {
				V value = arr[index].value;
				arr[index].value = null;
				return value;
			}
			
			index = (index + 1) % arr.length;
			
			if(index == startIndex) {
				return null;
			}
		}
		
		return null;
	}
	
	public void print() {
		for(Entry entry : arr) {
			System.err.print(entry.key + ":" + entry.value + ", ");
		}
		System.err.println();
	}

	class Entry {
		private K key;
		private V value;

		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
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
	}
}
