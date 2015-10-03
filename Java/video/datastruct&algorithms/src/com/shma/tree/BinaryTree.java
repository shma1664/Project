package com.shma.tree;

/**
 * ������
 * @author h p
 *
 * @param <T>
 */
public class BinaryTree<T> {

	private Node<T> root;
	
	/**
	 * ����ڵ�
	 * @param data
	 */
	public void insert(int key, T data) {
		Node<T> node = new Node<T>(data, key);
		
		Node<T> currNode = root;

		while(true) {
			if(currNode == null) {
				//���ڵ�Ϊ��
				root = node;
				break;
			} else {
				
				if(currNode.index > node.index) {
					//���
					if(currNode.leftNode == null) {
						currNode.leftNode = node;
						break;
					} else {
						currNode = currNode.leftNode;	
					}
				} else {
					if(currNode.rightNode == null) {
						currNode.rightNode = node;
						break;
					} else {
						currNode = currNode.rightNode;
					}
				}
			}
		}
	}
	
	public T find(int index) {
		Node<T> currNode = root;

		while(true) {
			
			if(currNode.index == index) {
				return currNode.data;
			}
			
			if(currNode.index > index) {
				//���
				if(currNode.leftNode == null) {
					return null;
				} else {
					currNode = currNode.leftNode;
				}
			} else {
				if(currNode.rightNode == null) {
					return null;
				} else {
					currNode = currNode.rightNode;
				}
			}
		}
		
	}
	
	public T delete(int index) {
		Node<T> currNode = root;
		Node<T> parentNode = root;
		boolean isLeftChild = false;
		while(true) {
			//û���ҵ���ֱ�ӷ���
			if(currNode == null) {
				return null;
			}
			
			if(currNode.index == index) {
				break;
			}
			parentNode = currNode;
			if(currNode.index > index) {
				isLeftChild = true;
				currNode = currNode.leftNode;
			} else {
				isLeftChild = false;
				currNode = currNode.rightNode;
			}
		}

		//����ӽڵ�Ϊ�գ���ΪҶ�ӽڵ�
		if(currNode.leftNode == null && currNode.rightNode == null) {
			//���Ϊ�����
			if(currNode == root) {
				root = null;
			} else {
				if(isLeftChild) {
					parentNode.leftNode = null;
				} else {
					parentNode.rightNode = null;
				}
			}
		} else if(currNode.rightNode == null) {
			if(currNode == root) {
				root = currNode.leftNode;
			} else {
				if(isLeftChild) {
					parentNode.leftNode = currNode.leftNode;
				} else {
					parentNode.rightNode = currNode.leftNode;
				}
			}
		} else if(currNode.leftNode == null) {
			if(currNode == root) {
				root = currNode.rightNode;
			} else {
				if(isLeftChild) {
					parentNode.leftNode = currNode.rightNode;
				} else {
					parentNode.rightNode = currNode.rightNode;
				}
			}
		} else {
			Node<T> successcor = getSuccesscor(currNode);
			if(currNode == root) {
				root = successcor;
			} else if(isLeftChild) {
				parentNode.leftNode = successcor;
			} else {
				parentNode.rightNode = successcor;
			}
			
			successcor.leftNode = currNode.leftNode;
		}
		
		return currNode.data;
	}
	
	private Node<T> getSuccesscor(Node<T> delNode) {
		Node<T> successcor = delNode;
		Node<T> parentSuccesscor = delNode;
		Node<T> currNode = delNode.rightNode;
		
		while(currNode != null) {
			parentSuccesscor = successcor;
			successcor = currNode;
			currNode = currNode.leftNode;
		}
		
		if(successcor != delNode) {
			parentSuccesscor.leftNode = successcor.rightNode;
			successcor.rightNode = delNode.rightNode;
		}
		
		return successcor;
	}
	
	/**
	 * ����������ȱ������ڵ㣬�ڱ������������ڱ���������
	 */
	public void preOrderTraverse(Node<T> node) {
		if(node != null) {
			System.out.println(node);
			preOrderTraverse(node.leftNode);
			preOrderTraverse(node.rightNode);
		}
		
	}
	
	/**
	 * �������:�ȱ������������ڱ������ڵ㣬�ڱ���������
	 */
	public void inOrderTraverse(Node<T> node) {
		if(node != null) {
			inOrderTraverse(node.leftNode);
			System.out.println(node);
			inOrderTraverse(node.rightNode);
		}
	}
	
	/**
	 * ����������ȱ������������ڱ������������ڱ������ڵ�
	 */
	public void postOrderTraverse(Node<T> node) {
		
		if(node != null) {
			postOrderTraverse(node.leftNode);
			postOrderTraverse(node.rightNode);
			System.out.println(node);
		}
	}
	
	public Node<T> getRoot() {
		return root;
	}

	class Node<E> {
		private int index;
		private E data;
		
		private Node<E> leftNode;
		
		private Node<E> rightNode;

		public Node(E data, int index) {
			super();
			this.data = data;
			this.index = index;
		}

		public Node(int index, E data, BinaryTree<T>.Node<E> leftNode, BinaryTree<T>.Node<E> rightNode) {
			super();
			this.index = index;
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node<E> getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node<E> leftNode) {
			this.leftNode = leftNode;
		}

		public Node<E> getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node<E> rightNode) {
			this.rightNode = rightNode;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", data=" + data + "]";
		}
	}
}
