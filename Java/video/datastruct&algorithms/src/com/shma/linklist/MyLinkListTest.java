package com.shma.linklist;

import org.junit.Test;

public class MyLinkListTest {

	@Test
	public void test() {
		MyLinkList<Long> linkList = new MyLinkList<Long>();
		linkList.add(10L);
		linkList.add(20L);
		linkList.add(30L);
		linkList.add(40L);
		linkList.add(0L);
		
		linkList.display();
		
		MyLinkList<Person> personList = new MyLinkList<Person>();
		personList.add(new Person(1, "ÂíÉØ»ª"));
		personList.add(new Person(2, "Æë½¿½¿"));
		personList.add(new Person(3, "ËïÍþ"));
		personList.add(new Person(4, "Tom"));
		personList.add(new Person(5, "·®»Û"));
		personList.add(new Person(6, "ÖÜÎ°"));
		personList.add(new Person(7, "ÄÌÍÞ"));
		personList.display();
		
		Person person = personList.del();
		System.out.println("±»É¾³ýµÄ£º" + person);
		personList.display();
		
		Person person2 = personList.find(new Person(5, "·®»Û"));
		System.out.println("Find£º" + person2);
		
		personList.display();
		
		Person person3 = personList.del(new Person(2, "Æë½¿½¿"));
		System.out.println("É¾³ýµÄ½Úµã£º" + person3);
		personList.display();
		
		Person person4 = personList.del(new Person(6, "ÖÜÎ°"));
		System.out.println("É¾³ýµÄ½Úµã£º" + person4);
		personList.display();
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
			return "Person [id=" + id + ", name=" + name + "]";
		}

		private MyLinkListTest getOuterType() {
			return MyLinkListTest.this;
		}
	}

}
