package com.shma.tree;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void test() {
		BinaryTree<Person> tree = new BinaryTree<Person>();
		tree.insert(10, new Person(10, "Tom"));
		tree.insert(20, new Person(20, "Lucy"));
		tree.insert(15, new Person(15, "LiLei"));
		tree.insert(16, new Person(16, "JJ"));
		tree.insert(23, new Person(23, "Shaohua"));
		tree.insert(41, new Person(41, "Shaohua"));
		tree.insert(40, new Person(40, "Shaohua"));
		tree.insert(50, new Person(50, "Shaohua"));
		tree.insert(5, new Person(50, "Shaohua"));
		tree.insert(3, new Person(50, "Shaohua"));
		tree.insert(4, new Person(50, "Shaohua"));
		tree.insert(2, new Person(50, "Shaohua"));
		tree.insert(9, new Person(50, "Shaohua"));
		tree.insert(7, new Person(50, "Shaohua"));
		tree.insert(6, new Person(50, "Shaohua"));
		tree.insert(8, new Person(50, "Shaohua"));
		
		System.out.println("----insert----");
		
		System.out.println(tree.getRoot());
		System.out.println(tree.getRoot().getRightNode());
		System.out.println(tree.getRoot().getRightNode().getLeftNode());
		System.out.println(tree.getRoot().getRightNode().getLeftNode().getRightNode());
		System.out.println(tree.getRoot().getRightNode().getRightNode());
	
		System.out.println("----find------");
		System.out.println(tree.find(10));
		System.out.println(tree.find(21));
		System.out.println(tree.find(20));
		System.out.println(tree.find(15));
		System.out.println(tree.find(16));
		System.out.println(tree.find(23));
		System.out.println(tree.find(98));
		
		System.out.println("-------先序遍历---------");
		tree.preOrderTraverse(tree.getRoot());
		
		System.out.println("---中序遍历--");
		tree.inOrderTraverse(tree.getRoot());
		
		System.out.println("---后序遍历--");
		tree.postOrderTraverse(tree.getRoot());
		
		System.out.println("----delete 10 ------");
		
		System.out.println(tree.delete(10));
		tree.inOrderTraverse(tree.getRoot());
		
		System.out.println("----delete 50 ------");
		
		System.out.println(tree.delete(50));
		tree.inOrderTraverse(tree.getRoot());
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Person [id=" + id + "]";
		}

		private BinaryTreeTest getOuterType() {
			return BinaryTreeTest.this;
		}
	}

}
