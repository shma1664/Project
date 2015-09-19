package com.shma.linklist;

/**
 * ˫������
 * @author h p
 *
 */
public class FirstLastLinkList<E> {

	private Node<E> firstNode;
	private Node<E> lastNode;
	
	public FirstLastLinkList() {
		
	}
	
	public FirstLastLinkList(Node<E> firstNode, Node<E> lastNode) {
		super();
		this.firstNode = firstNode;
		this.lastNode = lastNode;
	}
	
	/**
	 * ��ͷ����
	 * @param data
	 */
	public void insert2First(E data) {
		Node<E> node = new Node<E>(data);
		
		//��һ�β���
		if(isEmpty()) {
			lastNode = node;
		}
		
		node.next = firstNode;
		firstNode = node;
	}
	
	public void insert2Last(E data) {
		Node<E> node = new Node<E>(data);
		
		//��һ�β���
		if(isEmpty()) {
			firstNode = node;
		} else {
			lastNode.next = node;
		}
	
		lastNode = node;
	}
	
	/**
	 * ɾ��ͷ�ڵ�����
	 * @return
	 */
	public E delFirst() {
		
		if(isEmpty()) {
			return null;
		}
		
		Node<E> node = firstNode;
		if(firstNode.next != null) {
			firstNode = firstNode.next;
		} else {
			lastNode = null;
		}
		
		return node.data;
	}
	
	/**
	 * ����
	 * @param data
	 * @return
	 */
	public E find(E data) {
		Node<E> node = firstNode;
		while(node != null) {
			if(node.data != null && node.data.equals(data)) {
				return node.data;
			}
			
			node = node.next;
		}
		
		return null;
	}
	
	/**
	 * ɾ��ĳһ��Ԫ��
	 * @param data
	 * @return
	 */
	public E del(E data) {
		Node<E> node = firstNode;
		Node<E> prevNode = firstNode;
		while(node != null) {
			if(node.data != null && node.data.equals(data)) {
				if(firstNode == node) {
					firstNode = firstNode.next;	
				} else {
					prevNode.next = node.next;
				}
				return node.data;
			}
			
			prevNode = node;
			node = node.next;
		}
		
		return null;
	}
	
	/**
	 * ��ʾ
	 */
	public void display() {
		Node<E> node = firstNode;
		while(node != null) {
			System.out.print(node + " ");
			node = node.next;
		}
		
		System.out.println();
	}
	
	/**
	 * �Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return firstNode == null;
	}

	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node() {
			
		}
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
}
