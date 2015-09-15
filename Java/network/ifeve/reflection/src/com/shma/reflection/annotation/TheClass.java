package com.shma.reflection.annotation;

@MyAnnotation(name="userName", value="马韶华")
public class TheClass {

	@MyAnnotation(name="classes",  value = "三年二班")
	public String myField = null;

	
	@MyAnnotation(name="age", value="26")
	public void doSomething() {
		
	}
	
	public void init(@MyAnnotation(name="sex", value="男") String param) {
		
	}
}
