package com.shma.linklist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoubleLinkListTest {

	private DoubleLinkList<Person> linkList = new DoubleLinkList<Person>();
	
	@Before
	public void before() {
		linkList.insert2First(new Person(1, "AA"));
		linkList.insert2First(new Person(2, "BB"));
		linkList.insert2First(new Person(3, "CC"));
		linkList.insert2First(new Person(4, "DD"));
		linkList.insert2First(new Person(5, "EE"));
		linkList.inset2Last(new Person(6, "FF"));
		linkList.inset2Last(new Person(7, "GG"));
		linkList.inset2Last(new Person(8, "HH"));
		linkList.inset2Last(new Person(9, "II"));
		linkList.inset2Last(new Person(10, "JJ"));
	}
	
	@Test
	public void test() {
		linkList.displayFromFirst();
		linkList.displayFormLast();
	}
	
	@Test
	public void delFirst() {
		System.out.println(linkList.deleteFirst());
		linkList.displayFromFirst();
		System.out.println(linkList.deleteFirst());
		linkList.displayFromFirst();
	}
	
	@Test
	public void delLast() {
		System.out.println(linkList.delLast());
		linkList.displayFormLast();
		System.out.println(linkList.delLast());
		linkList.displayFormLast();
	}
	
	@Test
	public void find() {
		linkList.displayFromFirst();
		System.out.println(linkList.find2First(new Person(5, "EE")));
		linkList.displayFormLast();
		System.out.println(linkList.find2Last(new Person(5, "EE")));
	}
	
	@Test
	public void del() {
		System.out.println(linkList.delFromFirst(new Person(3, "CC")));
		linkList.displayFromFirst();
		
		System.out.println(linkList.delFromFirst(new Person(10, "JJ")));
		linkList.displayFromFirst();
		
		System.out.println(linkList.delFromLast(new Person(8, "HH")));
		linkList.displayFromFirst();
		
		System.out.println(linkList.delFromLast(new Person(1, "AA")));
		linkList.displayFromFirst();
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

		private DoubleLinkListTest getOuterType() {
			return DoubleLinkListTest.this;
		}

		@Override
		public String toString() {
			return "Person [id=" + id + "]";
		}
	}

}
