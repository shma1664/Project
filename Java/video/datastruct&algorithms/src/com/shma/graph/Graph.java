package com.shma.graph;

/**
 * 图
 * @author h p
 *
 * @param <T>
 */
public class Graph<T> {
	
	//顶点数组
	private Vertex<T>[] vertexs;
	
	//关联关系
	private int[][] cables;
	
	//当前顶点
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
	 * 添加顶点
	 * @param value
	 */
	public void addVertex(T value) {
		Vertex<T> vertex = new Vertex<T>(value);
		vertexs[currVertex++] = vertex;
	}
	
	/**
	 * 添加线
	 * @param start 开始
	 * @param end 结束
	 */
	public void addEdge(int start, int end) {
		cables[start][end] = 1;
		cables[end][start] = 1;
	}
	
	/**
	 * 深度搜索遍历
	 * 规则1：如果可能，访问一个相连的顶点，标记其访问状态，并放入栈中
	 * 规则2：如果规则1无法满足，如果栈不为空，则弹出一个栈顶点
	 * 规则3：如果规则1无法执行并且栈为空，则遍历结束
	 */
	public void dfs() {
		//处理顶点
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
	 * 访问下一个邻接的未访问顶点，标记并放入队列中
	 * 如果无法执行1，则队列中取出一个顶点，并执行1
	 * 当不能执行1,2时，则遍历结束
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
	 * 获取相连的顶点
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