package org.demo.springboot.attendance.schedule.dto;

import java.util.Date;

public class AttendanceDTO {

	private Long sid;
	private Long userId;
	private Date workDate;
	private Date clockIn;
	private Date clockOut;
	private String workStatus;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long employeeId) {
		this.userId = employeeId;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public Date getClockIn() {
		return clockIn;
	}

	public void setClockIn(Date clockIn) {
		this.clockIn = clockIn;
	}

	public Date getClockOut() {
		return clockOut;
	}

	public void setClockOut(Date clockOut) {
		this.clockOut = clockOut;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

}
