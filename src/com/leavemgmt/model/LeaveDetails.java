package com.leavemgmt.model;

public class LeaveDetails {
	
	@Override
	public String toString() {
		return "LeaveDetails [startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	private String startDate;
	
	private String endDate;
	
	public LeaveDetails() {
		
	}

	public LeaveDetails(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
