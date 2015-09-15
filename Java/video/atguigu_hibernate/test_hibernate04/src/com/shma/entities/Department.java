package com.shma.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Department {

	private int departId;
	
	private String depart_name;
	
	private int is_valid;
	
	private Date modify_date;
	
	private Set<Job> jobs = new HashSet<>();

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepart_name() {
		return depart_name;
	}

	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
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

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Department [departId=" + departId + ", depart_name=" + depart_name + "]";
	}
	
	
}
