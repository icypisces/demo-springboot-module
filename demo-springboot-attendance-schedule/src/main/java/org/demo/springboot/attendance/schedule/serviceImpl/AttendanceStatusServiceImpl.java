package org.demo.springboot.attendance.schedule.serviceImpl;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.demo.springboot.attendance.schedule.mapper.AttendanceMapper;
import org.demo.springboot.attendance.schedule.service.AttendanceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AttendanceStatusServiceImpl implements AttendanceStatusService {
	
	@Autowired
	AttendanceMapper attendanceMapper;
	
	@Value("${file.text.workStartTime}")
	private String workStartTime;
	
	@Value("${file.text.worEndTime}")
	private String worEndTime;
	
	@Override
	public void CheckInStatusSchedule() throws ParseException {
		Date yesterday = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		yesterday = calendar.getTime();
		attendanceMapper.generateAttendance(yesterday, workStartTime.replace("-",":").concat(":00"), worEndTime.replace("-",":").concat(":00"));
	}

}
