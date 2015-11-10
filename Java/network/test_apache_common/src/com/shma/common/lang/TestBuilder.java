package com.shma.common.lang;

import java.util.Date;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TestBuilder {

	public static void main(String[] args) {
		
		Staff staff1 = new Staff(123, "John Smith" , new Date());
        Staff staff2 = new Staff(456, "Jane Smith" , new Date());
        Staff staff3 = new Staff(456, "Jane Smith" , new Date());
        
        System.out.println( "staff1's info: " + staff1);

        System.out.println( "staff2's info: " + staff2);

        System.out.println( "staff1's hash code: " +staff1.hashCode());

        System.out.println( "staff2's hash code: " +staff2.hashCode());

        System.out.println( "staff3 equals staff2 ? " +staff2.equals(staff3));
	}
}

class Staff implements Comparable<Staff> {

	private long staffId;

    private String staffName;

    private Date dateJoined;

    public Staff() {

    }

    public Staff( long staffId, String staffName, Date dateJoined){

        this.staffId = staffId;
        this.staffName = staffName;
        this.dateJoined = dateJoined;

    }
	
	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	@Override
	public int compareTo(Staff strStaff) {
		int state = new CompareToBuilder()
					.append(dateJoined, strStaff.dateJoined)
					.append(staffName, strStaff.staffName)
					.toComparison();
		
		return state;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(staffId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean state = false;
		
		if(obj != null && Staff.class.isAssignableFrom(obj.getClass())) {
			Staff staff = (Staff) obj;
			state = new EqualsBuilder().
					append(staffId, staff.staffId).
					isEquals();
		}
		
		return state;
	}
}
