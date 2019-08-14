package org.demo.springboot.attendance.schedule.service;

import java.text.ParseException;

import org.springframework.stereotype.Service;

@Service
public interface AttendanceStatusService {

	public void CheckInStatusSchedule() throws ParseException;
	
	
}
