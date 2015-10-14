package com.shma.guava.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

/**
 * 用于替换Map<K, List<V>>或者Map<K, Set<V>>复杂数据结构
 * @author admin
 *
 */
public class MultimapTest {
	
	
	@Test
	public void testGuavaMethod() {
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(1, "AAA", 1001));
		persons.add(new Person(2, "BBB", 1001));
		persons.add(new Person(3, "CCC", 1002));
		persons.add(new Person(4, "DDD", 1002));
		persons.add(new Person(5, "EEE", 1001));
		persons.add(new Person(6, "FFF", 1001));
		persons.add(new Person(7, "GGG", 1003));
		persons.add(new Person(8, "HHH", 1003));
		persons.add(new Person(9, "III", 1002));
		persons.add(new Person(10, "JJJ", 1003));
		
		ListMultimap<Integer, Person> multimap = guavaMethod(persons);
		System.out.println(multimap.keys());
		
	}

	/**
	 * 传统方法
	 */
	public Map<Integer, List<Person>> traditMethod(List<Person> persons) {
		Map<Integer, List<Person>> personMap = new HashMap<Integer, List<Person>>();
		for(Person person : persons) {
			List<Person> itemList = null;
			if((itemList = personMap.get(person.getClassId())) == null) {
				itemList = new ArrayList<Person>();
			}
			
			itemList.add(person);
		}
		
		return personMap;
	}
	
	public ListMultimap<Integer, Person> guavaMethod(List<Person> persons) {
		ListMultimap<Integer, Person> multimap = ArrayListMultimap.create();
		for(Person person : persons) {
			multimap.put(person.getClassId(), person);
		}
		
		return multimap;
	}
	
	class Person {
		
		private int id;
		private String person;
		private int classId;
		
		public Person(int id, String person, int classId) {
			super();
			this.id = id;
			this.person = person;
			this.classId = classId;
		}

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getPerson() {
			return person;
		}
		
		public void setPerson(String person) {
			this.person = person;
		}
		
		public int getClassId() {
			return classId;
		}
		
		public void setClassId(int classId) {
			this.classId = classId;
		}
		
		@Override
		public String toString() {
			return "Person [id=" + id + ", person=" + person + ", classId="
					+ classId + "]";
		}
		
		
	}
}
