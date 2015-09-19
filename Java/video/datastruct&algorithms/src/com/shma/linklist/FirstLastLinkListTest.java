package com.shma.linklist;

import org.junit.Before;
import org.junit.Test;

public class FirstLastLinkListTest {

	private FirstLastLinkList<Person> linkList = new FirstLastLinkList<Person>();
	
	@Before
	public void Before() {
		linkList.insert2Last(new Person(6, "FF"));
		linkList.insert2Last(new Person(7, "GG"));
		linkList.insert2Last(new Person(8, "HH"));
		linkList.insert2Last(new Person(9, "II"));
		linkList.insert2Last(new Person(10, "JJ"));
		linkList.insert2First(new Person(1, "AA"));
		linkList.insert2First(new Person(2, "BB"));
		linkList.insert2First(new Person(3, "CC"));
		linkList.insert2First(new Person(4, "DD"));
		linkList.insert2First(new Person(5, "EE"));

	}
	
	@Test
	public void test() {
		linkList.display();
	}
	
	@Test
	public void find() {
		System.out.println(linkList.find(new Person(1, "AA")));
		System.out.println(linkList.find(new Person(4, "DD")));
		System.out.println(linkList.find(new Person(5, "EE")));
	}
	
	@Test
	public void deleteFirst() {
		System.out.println(linkList.delFirst());
		linkList.display();
		System.out.println(linkList.delFirst());
		linkList.display();
		System.out.println(linkList.delFirst());
		linkList.display();
	}
	
	@Test
	public void del() {
		
		System.out.println(linkList.del(new Person(5, "EE")));
		linkList.display();
		System.out.println(linkList.del(new Person(1, "AA")));
		linkList.display();
		
		System.out.println(linkList.del(new Person(10, "JJ")));
		linkList.display();
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

		private FirstLastLinkListTest getOuterType() {
			return FirstLastLinkListTest.this;
		}

	} 

}
