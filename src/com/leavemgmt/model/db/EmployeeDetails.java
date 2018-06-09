package com.leavemgmt.model.db;

import org.bson.types.ObjectId;

public class EmployeeDetails {

	private ObjectId _id;

	private String name;

	private String company;

	private Integer experiance;

	private LeaveDetails leaveDetails;

	private Integer totalCount;

	public EmployeeDetails(ObjectId _id, String name, String company, Integer experiance, LeaveDetails leaveDetails,
			Integer totalCount) {
		super();
		this._id = _id;
		this.name = name;
		this.company = company;
		this.experiance = experiance;
		this.leaveDetails = leaveDetails;
		this.totalCount = totalCount;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
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

}
