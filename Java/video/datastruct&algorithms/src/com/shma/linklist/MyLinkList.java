package com.shma.linklist;

public class MyLinkList<E> {

	private Node<E> firstNode;
	
	public MyLinkList() {
		
	}
	
	public MyLinkList(E e) {
		this.firstNode = new Node<E>(e);
	}
	
	/**
	 * ��ӽڵ�
	 * @param t
	 */
	public void add(E e) {
		Node<E> node = new Node<E>(e);
		node.nextNode = firstNode;
		firstNode = node;
	}
	
	/**
	 * ɾ��ͷ�ڵ�
	 * @return
	 */
	public E del() {
		Node<E> node = firstNode;
		firstNode = firstNode.nextNode;
		return node.data;
	}
	
	/**
	 * ����Ԫ��
	 * @param value
	 * @return
	 */
	public E find(E value) {
		Node<E> tmpNode = firstNode;
		while(tmpNode != null) {
			if(tmpNode.data != null && tmpNode.data.equals(value)) {
				return tmpNode.data;
			}
			
			tmpNode = tmpNode.nextNode;
		}
		
		return null;
	}
	
	/**
	 * ɾ��Ԫ��
	 * @param value
	 * @return
	 */
	public E del(E value) {
		
		Node<E> tmpNode = firstNode;
		Node<E> prevNode = firstNode;
		
		while(tmpNode != null) {
			if(tmpNode.data != null && tmpNode.data.equals(value)) {
				//ɾ������
				if(tmpNode == firstNode) {
					firstNode = firstNode.nextNode;
				} else {
					prevNode.nextNode = tmpNode.nextNode;
				}
				
				return tmpNode.data;
			}
			prevNode = tmpNode;
			tmpNode = tmpNode.nextNode;
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
			node = node.nextNode;
		}
		System.out.println();
	}
	
	class Node<T> {
		private T data;
		private Node<T> nextNode;
		
		public Node() {
			super();
		}

		public Node(T data) {
			super();
			this.data = data;
		}

		public Node(T data, Node<T> nextNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
}
