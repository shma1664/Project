package com.shma.reflection.annotation;

@MyAnnotation(name="userName", value="���ػ�")
public class TheClass {

	@MyAnnotation(name="classes",  value = "�������")
	public String myField = null;

	
	@MyAnnotation(name="age", value="26")
	public void doSomething() {
		
	}
	
	public void init(@MyAnnotation(name="sex", value="��") String param) {
		
	}
}
