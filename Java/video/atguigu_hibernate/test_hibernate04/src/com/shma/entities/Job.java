package com.shma.entities;

import java.util.Date;

public class Job {

	private int job_id;
	
	private String job_name;
	
	private String job_description;
	
	private String experience_required;
	
	private int is_valid;
	
	private Date modify_date;
	
	private Department dept;

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getExperience_required() {
		return experience_required;
	}

	public void setExperience_required(String experience_required) {
		this.experience_required = experience_required;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Job [job_id=" + job_id + ", job_name=" + job_name + ", job_description=" + job_description + ", dept="
				+ dept + "]";
	}

	public Job(String job_name, String job_description, Department dept) {
		super();
		this.job_name = job_name;
		this.job_description = job_description;
		this.dept = dept;
	}

	public Job() {
		super();
	}
	
}
