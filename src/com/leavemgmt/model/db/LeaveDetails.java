package com.leavemgmt.model.db;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author skaushik
 *
 */
public class LeaveDetails {

	public LeaveDetails(LocalDate localDate, LocalDate localDate2) {
		super();
		this.startDate = localDate;
		this.endDate = localDate2;
	}

	private LocalDate startDate;

	private LocalDate endDate;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
