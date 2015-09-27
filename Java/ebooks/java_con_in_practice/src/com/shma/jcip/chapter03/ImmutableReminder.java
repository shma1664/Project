package com.shma.jcip.chapter03;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.shma.jcip.annotation.ThreadSafe;

/**
 * 不可变对象
 * @author admin
 *
 */
@ThreadSafe
public final class ImmutableReminder {

	private final Set<String> stooges = new HashSet<String>();
	
	private final Date remindingDate;
	
	private final String name;
	
	private final String mobile;

	public ImmutableReminder(Date remindingDate, String name, String mobile) {
		super();
		if(remindingDate.getTime() < System.currentTimeMillis()) {
			throw new IllegalArgumentException("Can not set reminder for past time: " + remindingDate);
		}        
		this.remindingDate = new Date(remindingDate.getTime());
		this.name = name;
		this.mobile = mobile;
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}

	public boolean isStooge(String name) {
		return stooges.contains(name);
	}

	public Date getRemindingDate() {
		return new Date(remindingDate.getTime());
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

}
