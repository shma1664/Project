package com.shma.hash;

/**
 * ¡¥µÿ÷∑∑®
 * @author h p
 *
 */
public class HashTable3<K, V> {

	private LinkList[] arr;
	
	public HashTable3(int size) {
		arr = new HashTable3.LinkList[size];
	}
	
	public void insert(K key, V value) {
		LinkList linkList = arr[hashCode(key)];
		if(linkList == null) {
			linkList = new LinkList();
			arr[hashCode(key)] = linkList;
		}
		linkList.insertFirst(key, value);
	}
	
	public V find(K key) {
		LinkList linkList = arr[hashCode(key)];
		if(linkList == null) {
			return null;
		}
		return linkList.find(key);
	}
	
	public V delete(K key) {
		LinkList linkList = arr[hashCode(key)];
		if(linkList == null) {
			return null;
		}
		return linkList.delete(key);
	}
	
	public int hashCode(K key) {
		return key.hashCode() % arr.length;
	}
	
	class LinkList {
		private Node firstNode;
		
		public LinkList() {
			
		}
		
		public void insertFirst(K key, V value) {
			Node node = new Node(key, value);
			node.nextNode = firstNode;
			firstNode = node;
		}
		
		public V find(K key) {
			Node node = firstNode;
			while(node != null && !node.key.equals(key)) {
				node = node.nextNode;
			}
			
			return node != null ? node.value : null;
		}
		
		public V delete(K key) {
			Node node = firstNode;
			Node parentNode = null;
			while(node != null && !node.key.equals(key)) {
				parentNode = node;
				node = node.nextNode;
			}
			
			if(node == null) {
				return null;
			}
			
			if(node == firstNode) {
				firstNode = firstNode.nextNode;
			} else {
				parentNode.nextNode = node.nextNode;
			}
			
			return node.value;
		}
		
		class Node {
			
			private K key;
			private V value;
			
			private Node nextNode;

			public Node(K key, V value) {
				super();
				this.key = key;
				this.value = value;
			}

			public Node(K key, V value, HashTable3<K, V>.LinkList.Node nextNode) {
				super();
				this.key = key;
				this.value = value;
				this.nextNode = nextNode;
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

			public Node getNextNode() {
				return nextNode;
			}

			public void setNextNode(Node nextNode) {
				this.nextNode = nextNode;
			}
			
			
		}
		
	}
}
