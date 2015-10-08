package com.shma.graph;

import org.junit.Test;

public class GraphTest {

	@Test
	public void test() {
		Graph<Person> graph = new Graph<Person>(6);
		graph.addVertex(new Person(0, "ÂíÉØ»ª"));
		graph.addVertex(new Person(1, "Æë½¿½¿"));
		graph.addVertex(new Person(2, "ËïÍş"));
		graph.addVertex(new Person(3, "·®»Û"));
		graph.addVertex(new Person(4, "Íõ¼ÒÀ«"));
		graph.addVertex(new Person(5, "ÖÜÎ°"));
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(4, 5);
		
		graph.dfs();
		graph.widthSearch();
		
		graph.mst();
	}
	
	class Person {
		
		private int id;
		private String name;
		
		public Person(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + "]";
		}
	}

}
