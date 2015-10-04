package com.shma.graph;

/**
 * ͼ
 * @author h p
 *
 * @param <T>
 */
public class Graph<T> {
	
	//��������
	private Vertex<T>[] vertexs;
	
	//������ϵ
	private int[][] cables;
	
	//��ǰ����
	private int currVertex;
	
	private Stack<Integer> stack;
	
	private Queue<Integer> queue;
	
	public Graph(int maxSize) {
		vertexs = new Vertex[maxSize];
		currVertex = 0;
		cables = new int[maxSize][maxSize];
		for(int i=0; i<maxSize; ++i) {
			for(int j=0; j<maxSize; ++j) {
				cables[i][j] = 0;
			}
		}
		stack = new Stack<Integer>(Integer.class, maxSize);
		queue = new Queue<>(Integer.class, maxSize);
	}
	
	/**
	 * ��Ӷ���
	 * @param value
	 */
	public void addVertex(T value) {
		Vertex<T> vertex = new Vertex<T>(value);
		vertexs[currVertex++] = vertex;
	}
	
	/**
	 * �����
	 * @param start ��ʼ
	 * @param end ����
	 */
	public void addEdge(int start, int end) {
		cables[start][end] = 1;
		cables[end][start] = 1;
	}
	
	/**
	 * �����������
	 * ����1��������ܣ�����һ�������Ķ��㣬��������״̬��������ջ��
	 * ����2���������1�޷����㣬���ջ��Ϊ�գ��򵯳�һ��ջ����
	 * ����3���������1�޷�ִ�в���ջΪ�գ����������
	 */
	public void dfs() {
		//������
		int index = 0;
		display(index);
		stack.push(index);
		
		while(!stack.isEmpty()) {
			index = getadjUnvisitedVertex(stack.peek());
			if(index != -1) {
				display(index);
				stack.push(index);
			} else {
				stack.pop();
			}
		}
		
		for(Vertex<T> vertex : vertexs) {
			vertex.setVisited(false);
		}
	}
	
	/**
	 * ������һ���ڽӵ�δ���ʶ��㣬��ǲ����������
	 * ����޷�ִ��1���������ȡ��һ�����㣬��ִ��1
	 * ������ִ��1,2ʱ�����������
	 */
	public void widthSearch() {
		int index = 0;
		queue.insert(index);
		display(index);
		while(!queue.isEmpty()) {
			
			index = getadjUnvisitedVertex(queue.peek());
			
			while(index != -1) {
				queue.insert(index);
				display(index);
				index = getadjUnvisitedVertex(queue.peek());
				
			}
			
			queue.remove();
		}
		
		for(Vertex<T> vertex : vertexs) {
			vertex.setVisited(false);
		}
	}
	
	public void mst() {
		int index = 0;
		Vertex<T> vertex = vertexs[index];
		vertex.setVisited(true);
		stack.push(index);
		while(!stack.isEmpty()) {
			int currIndex = stack.peek();
			int nextIndex = getadjUnvisitedVertex(currIndex);
			if(nextIndex == -1) {
				stack.pop();
			} else {
				vertexs[nextIndex].setVisited(true);
				stack.push(nextIndex);
				System.out.println(vertexs[currIndex].getData() + "-" + vertexs[nextIndex].getData());
			}
		}
		
		for(Vertex<T> tmp : vertexs) {
			tmp.setVisited(false);
		}
	}
	
	/**
	 * ��ȡ�����Ķ���
	 * @param index
	 * @return
	 */
	private int getadjUnvisitedVertex(int index) {
		for(int i=0; i<vertexs.length; ++i) {
			if(cables[index][i] == 1 && !vertexs[i].isVisited()) {
				return i;
			}
		}
		
		return -1;
	}
	
	private void display(int index) {
		Vertex<T> vertex = vertexs[index];
		vertex.setVisited(true);
		System.out.println(vertex.getData());
	}
}