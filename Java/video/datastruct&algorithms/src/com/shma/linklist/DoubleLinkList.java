package com.shma.linklist;

import java.awt.Frame;

/**
 * ˫������
 * @author h p
 *
 */
public class DoubleLinkList<E> {

	private Node<E> firstNode;
	private Node<E> lastNode;
	
	public DoubleLinkList() {
		
	}
	
	public DoubleLinkList(Node<E> firstNode, Node<E> lastNode) {
		this.firstNode = firstNode;
		this.lastNode = lastNode;
	}
	
	/**
	 * ��ͷ�ڵ����
	 * @param value
	 */
	public void insert2First(E value) {
		Node<E> node = new Node<E>(value);
		if(isEmpty()) {
			lastNode = node;
		} else {
			firstNode.prevNode = node;
		}
		
		node.nextNode = firstNode;
		firstNode = node;
	}
	
	/**
	 * ��β�ڵ����
	 * @param value
	 */
	public void inset2Last(E value) {
		Node<E> node = new Node<E>(value);
		if(isEmpty()) {
			firstNode = node;
		} else {
			lastNode.nextNode = node;
		}
		node.prevNode = lastNode;
		lastNode = node;
	}
	
	/**
	 * ��ͷ��β
	 */
	public void displayFromFirst() {
		
		if(isEmpty()) {
			return ;
		}
		
		Node<E> node = firstNode;
		while(node != null) {
			System.out.print(node + ",");
			node = node.nextNode;
		}
		System.out.println();
	}
	
	public void displayFormLast() {
		
		if(isEmpty()) {
			return ;
		}
		
		Node<E> node = lastNode;
		while(node != null) {
			System.out.print(node + ",");
			node = node.prevNode;
		}
		System.out.println();
	}
	
	/**
	 * ɾ����һ��
	 * @return
	 */
	public E deleteFirst() {
		
		if(isEmpty()) {
			return null;
		}
		Node<E> node = firstNode;
		if(firstNode.nextNode != null) {
			firstNode.nextNode.prevNode = null;
		} else {
			lastNode = null;
		}
		firstNode = firstNode.nextNode;
		return node.data;
		
	}
	
	/**
	 * ɾ�����һ��
	 */
	public E delLast() {
		
		if(isEmpty()) {
			return null;
		}
		
		Node<E> node = lastNode;
		
		if(lastNode.prevNode != null) {
			lastNode.prevNode.nextNode = null;
		} else {
			firstNode = null;
		}
		
		lastNode = lastNode.prevNode;
		return node.data;
	}
	
	/**
	 * ��ͷ����ʼ����
	 * @param value
	 * @return
	 */
	public int find2First(E value) {
		Node<E> node = firstNode;
		int index = -1;
		boolean isFind = false;
		while(node != null) {
			index++;
			if(node.data != null && node.data.equals(value)) {
				isFind = true;
				break;
			} else {
				node = node.nextNode;
			}
		}
		
		return isFind ? index : -1;
		
	}
	
	/**
	 * ��β����ʼ��
	 * @param value
	 * @return
	 */
	public int find2Last(E value) {
		Node<E> node = lastNode;
		int index = -1;
		boolean isFind = false;
		while(node != null) {
			index++;
			if(node.data != null && node.data.equals(value)) {
				isFind = true;
				break;
			} else {
				node = node.prevNode;
			}
		}
		
		return isFind ? index : -1;
	}
	
	/**
	 * ɾ��ĳ��Ԫ��
	 * @param value
	 * @return
	 */
	public E delFromFirst(E value) {
		Node<E> node = firstNode;
		while(node != null) {
			if(node.data != null && node.data.equals(value)) {
				
				if(node.prevNode == null) {
					if(node.nextNode == null) {
						lastNode = null;
					} else {
						//��һ���ڵ�
						node.nextNode.prevNode = null;
						firstNode = node.nextNode;
					}
					
				} else if(node.nextNode == null) {
					if(node.prevNode == null) {
						firstNode = null;
					} else {
						//���һ���ڵ�
						node.prevNode.nextNode = null;
						lastNode = node.prevNode;
					}
				} else {
					node.nextNode.prevNode = node.prevNode;
					node.prevNode.nextNode = node.nextNode;
				}
				return node.data;
			} else {
				node = node.nextNode;
			}
		}
		
		return null;
	}
	
	public E delFromLast(E value) {
		Node<E> node = lastNode;
		while(node != null) {
			if(node.data != null && node.data.equals(value)) {
				if(node.nextNode == null) {
					if(node.prevNode == null) {
						firstNode = null;
					} else {
						//��һ���ڵ�
						node.prevNode.nextNode = null;
						lastNode = node.prevNode;
					}
					
				} else if(node.prevNode == null) {
					if(node.nextNode == null) {
						lastNode = null;
					} else {
						//���һ���ڵ�
						node.nextNode.prevNode = null;
						firstNode = node.nextNode;
					}
				} else {
					node.nextNode.prevNode = node.prevNode;
					node.prevNode.nextNode = node.nextNode;
				}
				
				return node.data;
			} else {
				node = node.prevNode;
			}
		}
		return null;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	class Node<T> {
		private T data;
		private Node<T> prevNode;
		private Node<T> nextNode;
		
		public Node() {
			super();
		}

		public Node(T data) {
			super();
			this.data = data;
		}

		public Node(Node<T> prevNode, Node<T> nextNode) {
			super();
			this.prevNode = prevNode;
			this.nextNode = nextNode;
		}

		public Node(T data, Node<T> prevNode, Node<T> nextNode) {
			super();
			this.data = data;
			this.prevNode = prevNode;
			this.nextNode = nextNode;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(Node<T> prevNode) {
			this.prevNode = prevNode;
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
