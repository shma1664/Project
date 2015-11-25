package com.shma.guava.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * Ordering是Guava类库提供的一个犀利强大的比较器工具
 * 
 * @author admin
 * 
 */
public class OrderingTest {

	/**
	 * natural()：使用Comparable类型的自然顺序， 例如：整数从小到大，字符串是按字典顺序; 　　 usingToString()
	 * ：使用toString()返回的字符串按字典顺序进行排序； 　　 arbitrary() ：返回一个所有对象的任意顺序， 即compare(a,
	 * b) == 0 就是 a == b (identity equality)。 本身的排序是没有任何含义， 但是在VM的生命周期是一个常量。
	 */
	@Test
	public void testStaticOrdering() {
		List<String> list = Lists.newArrayList();
		list.add("peida");
		list.add("jerry");
		list.add("harry");
		list.add("eva");
		list.add("jhon");
		list.add("neron");

		System.out.println("list:" + list);

		Ordering<String> naturalOrdering = Ordering.natural();
		Ordering<Object> usingToStringOrdering = Ordering.usingToString();
		Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

		System.out.println(naturalOrdering.sortedCopy(list));
		System.out.println(usingToStringOrdering.sortedCopy(list));
		System.out.println(arbitraryOrdering.sortedCopy(list));

		System.out.println("list:" + list);
	}

	@Test
	public void testOrdering() {
		List<Integer> numbers = Lists.newArrayList();
		numbers.add(new Integer(5));
		numbers.add(new Integer(2));
		numbers.add(new Integer(15));
		numbers.add(new Integer(51));
		numbers.add(new Integer(53));
		numbers.add(new Integer(35));
		numbers.add(new Integer(45));
		numbers.add(new Integer(32));
		numbers.add(new Integer(43));
		numbers.add(new Integer(16));

		Ordering<Integer> ordering = Ordering.natural();
		System.out.println("Input numbers:" + numbers);
		Collections.sort(numbers, ordering);
		System.out.println("Output numbers:" + numbers);
		System.out.println("Is order:" + ordering.isOrdered(numbers));
		ordering = ordering.reverse();
		Collections.sort(numbers, ordering);
		System.out.println("Output reverse numbers:" + numbers);
		System.out.println("Is order:" + ordering.isOrdered(numbers));

		System.out.println("Mininum:" + ordering.min(numbers));
		System.out.println("Maxinum:" + ordering.max(numbers));

		numbers.add(null);
		System.out.println("Add null numbers:" + numbers);
		Collections.sort(numbers, ordering.nullsFirst());
		System.out.println("Add null ordering:" + numbers);

		List<String> names = new ArrayList<String>();
		names.add("Ram");
		names.add("Shyam");
		names.add("Mohan");
		names.add("Sohan");
		names.add("Ramesh");
		names.add("Suresh");
		names.add("Naresh");
		names.add("Mahesh");
		names.add(null);
		names.add("Vikas");
		names.add("Deepak");

		Ordering<Object> orderingStr = Ordering.usingToString();
		System.out.println("Another List: ");
		System.out.println(names);
		Collections.sort(names, orderingStr.nullsFirst().reverse());
		System.out.println("Null first then reverse sorted list: ");
	    System.out.println(names);
	}
	
	@Test
	public void classByOrderingTest() {
		Ordering<Person> ordering = Ordering.natural()
											.nullsFirst()
											.onResultOf(new Function<Person, String>() {

												@Override
												public String apply(
														Person person) {
													return Objects.toStringHelper(person)
																	.addValue(person.name)
																	.addValue(person.age)
																	.toString();
												}
											
											});
		List<Person> persons = Lists.newArrayList();
		persons.add(new Person("shma", 11));
		persons.add(new Person("shma", 2));
		persons.add(new Person("jjq", 21));
		persons.add(new Person("sunwei", 23));
		persons.add(new Person("sunwei", 28));
		persons.add(new Person("jjq", 15));
		persons.add(new Person("haha", 1));
		
		Collections.sort(persons, ordering);
	}
	
	class Person {
		private String name;
		private int age;
		
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	
	}
}
