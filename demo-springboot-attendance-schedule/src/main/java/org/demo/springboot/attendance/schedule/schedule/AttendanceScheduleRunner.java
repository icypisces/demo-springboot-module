package org.demo.springboot.attendance.schedule.schedule;

import org.demo.springboot.attendance.schedule.serviceImpl.AttendanceStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class AttendanceScheduleRunner implements CommandLineRunner {
	
	@Autowired
	AttendanceStatusServiceImpl attendanceStatusService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("AttendanceScheduleRunner start ..............................");
		attendanceStatusService.CheckInStatusSchedule();
	}

}
