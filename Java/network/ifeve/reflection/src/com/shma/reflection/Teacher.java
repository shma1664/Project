package com.shma.reflection;

import java.util.List;

public class Teacher extends Person {

	private String subjectName;
	
	private List<Student> students;

	public Teacher() {
		super();
	}

	public Teacher(int id, String name, String subjectName, List<Student> students) {
		super(id, name);
		this.subjectName = subjectName;
		this.students = students;
	}

	public Teacher(String subjectName, List<Student> students) {
		super();
		this.subjectName = subjectName;
		this.students = students;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
