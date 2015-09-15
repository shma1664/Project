package com.shma.reflection;

public class Student extends Person {

	private String classesName;
	
	private Teacher teacher;
	
	public String myNameString;
	
	public static Integer currState;

	public Student() {
		super();
	}

	public Student(int id, String name, String classesName, Teacher teacher) {
		super(id, name);
		this.classesName = classesName;
		this.teacher = teacher;
	}

	public Student(String classesName, Teacher teacher) {
		super();
		this.classesName = classesName;
		this.teacher = teacher;
	}

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	private void changeName() {
		
	}
	
	public static void print(int state) {
		currState = state;
		System.out.println("µ±Ç°×´Ì¬Îª£º" + currState);
	}

	@Override
	public String toString() {
		return "Student [classesName=" + classesName + ", teacher=" + teacher
				+ "]";
	}
}
