package com.leavemgmt.model;

import java.util.Arrays;

public class EmployeeDetails {

	private String _id;
	
	private String name;
	
	private String company;
	
	private Integer experiance;
	
	private LeaveDetails leaveDetails;
	
	private LeaveDetails[] existingLeaveDetails;

	public EmployeeDetails(String _id, String name, String company, Integer experiance, LeaveDetails leaveDetails,
			Integer totalCount, LeaveDetails[] existingLeaveDetails) {
		super();
		this._id = _id;
		this.name = name;
		this.company = company;
		this.experiance = experiance;
		this.leaveDetails = leaveDetails;
		this.totalCount = totalCount;
		this.existingLeaveDetails = existingLeaveDetails;
	}
	
	@Override
	public String toString() {
		return "EmployeeDetails [_id=" + _id + ", name=" + name + ", company=" + company + ", experiance=" + experiance
				+ ", leaveDetails=" + leaveDetails + ", existingLeaveDetails=" + Arrays.toString(existingLeaveDetails)
				+ ", totalCount=" + totalCount + "]";
	}

	public EmployeeDetails() {
		
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getExperiance() {
		return experiance;
	}

	public void setExperiance(Integer experiance) {
		this.experiance = experiance;
	}

	public LeaveDetails getLeaveDetails() {
		return leaveDetails;
	}

	public void setLeaveDetails(LeaveDetails leaveDetails) {
		this.leaveDetails = leaveDetails;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	private Integer totalCount;

	public LeaveDetails[] getExistingLeaveDetails() {
		return existingLeaveDetails;
	}

	public void setExistingLeaveDetails(LeaveDetails[] existingLeaveDetails) {
		this.existingLeaveDetails = existingLeaveDetails;
	}

}
