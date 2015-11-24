package com.shma.guava.base;

import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * 复写Object中的方法实现
 * @author admin
 *
 */
public class TestObjects {
	
	class Student implements Comparable<Student> {
		private String name;
		private int age;
		private int score;
		
		public Student() {
			super();
		}

		public Student(String name, int age, int score) {
			super();
			this.name = name;
			this.age = age;
			this.score = score;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this)
						  .add("name", name)
						  .add("age", age)
						  .add("score", score)
						  .toString();
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(name, age);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Student) {
	            Student that = (Student) obj;
	            return Objects.equal(name, that.name)
	                    && Objects.equal(age, that.age)
	                    && Objects.equal(score, that.score);
	        }
	        return false;
		}

		@Override
		public int compareTo(Student student) {
			return ComparisonChain.start()
								  .compare(this.name, student.name)
								  .compare(this.age, student.age)
								  .compare(this.score, student.score)
								  .result();
		}

	}
	
	@Test
	public void compareTest() {
		Person person1 = new Person("jqq", 24);
		Person person2 = new Person("jqq", 28);
		Person person3 = new Person("shma", 24);
		Person person4 = new Person("shma", 21);
		Person person5 = new Person("shma", 21);
		System.out.println(person1.compareTo(person2));
		System.out.println(person1.compareTo(person3));
		System.out.println(person3.compareTo(person4));
		System.out.println(person5.compareTo(person4));
	}
	
	@Test
	public void toStringTest() {
		System.out.println(Objects.toStringHelper(this).add("name", "shma").toString());
		System.out.println(Objects.toStringHelper(Person.class).add("name", "shma").add("age", 23).toString());
		
		Person person1 = new Person("jqq", 24);
		Person person2 = new Person("jqq", 24);
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());
		System.out.println(person1.equals(person2));
	}

	@Test
	public void equalsTest() {
		System.out.println(Objects.equal(null, "a")); //false
		System.out.println(Objects.equal("a", "a")); //true
		System.out.println(Objects.equal("", "")); //true
		System.out.println(Objects.equal("a", "")); //false
		System.out.println(Objects.equal(null, null)); //true
		
		System.out.println(Objects.equal(new Person("shma", 23), new Person("shma", 23))); //false
		
		Person person = new Person("jqq", 24);
		System.out.println(Objects.equal(person, person)); //true
	}
	
	@Test
	public void hashCodeTest() {
		System.out.println(Objects.hashCode("a")); //128
		System.out.println(Objects.hashCode("a")); //128
		
		System.out.println(Objects.hashCode("a", "b")); //4066
		System.out.println(Objects.hashCode("b", "a")); //4096
		
		System.out.println(Objects.hashCode("b", "a", "c")); //127075
		System.out.println(Objects.hashCode("a", "c", "b")); //126175
		
		System.out.println(Objects.hashCode(new Person("shma", 23))); //21648900
		System.out.println(Objects.hashCode(new Person("shma", 23))); //21846074
		
		Person person = new Person("jqq", 24);
		System.out.println(Objects.hashCode(person)); //13856786
		System.out.println(Objects.hashCode(person)); //13856786
	}
	
	class Person implements Comparable<Person> {
	    public String name;
	    public int age;

	    Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

		@Override
		public String toString() {
			return Objects.toStringHelper(Person.class)
									.add("name", this.name)
									.add("age", this.age)
									.toString();
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(name, age);
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
			if(this.name == other.name && this.age == other.age) 
				return true;
			return false;
		}

		@Override
		public int compareTo(Person perosn) {
			
			return ComparisonChain.start()
								  .compare(this.name, perosn.name)
								  .compare(this.age, perosn.age)
								  .result();
		}

	}
}
