package org.demo.springboot.attendance.schedule.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.demo.springboot.attendance.schedule.dto.AttendanceDTO;

@Mapper
public interface AttendanceMapper {
	
	@Select("SELECT * FROM employee.attendance")
	@Results({
        @Result(property = "employeeId", column = "employee_id"),
        @Result(property = "workDate", column = "work_date"),
        @Result(property = "clockIn", column = "clock_in"),
        @Result(property = "clockOut", column = "clock_out"),
        @Result(property = "workStatus", column = "work_status")
	})
	List<AttendanceDTO> queryAllAttendanceData();
	
	@Insert("INSERT INTO employee.attendance(employee_id,work_date,clock_in,clock_out,work_status) \n" +
				"SELECT emp.employee_id, #{attendanceDate}, c.clock_in, c.clock_out \n" +
						",CASE WHEN c.clock_in IS NULL OR c.clock_out IS NULL THEN '0' \n" +
                              "WHEN DATE_FORMAT(c.clock_in, '%H:%i:%S') > #{workStartTime} AND DATE_FORMAT(c.clock_out, '%H:%i:%S') < #{worEndTime}  THEN '-1&-2' \n" +
                              "WHEN DATE_FORMAT(c.clock_in, '%H:%i:%S') > #{workStartTime} THEN '-1' \n" +
                              "WHEN DATE_FORMAT(c.clock_out, '%H:%i:%S') < #{worEndTime} THEN '-2' \n" +
                              "ELSE '1' END \n" +
                "FROM (SELECT employee_id FROM employee.employee_info WHERE status='1') emp \n" +
                    "LEFT JOIN (SELECT employee_id, MIN(check_in) AS clock_in, MAX(check_in) AS clock_out FROM employee.check_in \n" +
                                        "WHERE DATE_FORMAT(check_in, '%Y-%m-%d') = DATE_FORMAT(#{attendanceDate},'%Y-%m-%d') \n" +
                                        "GROUP BY employee_id \n" +
                    ") c ON emp.employee_id=c.employee_id")
	long generateAttendance(@Param("attendanceDate")Date attendanceDate, @Param("workStartTime")String workStartTime, @Param("worEndTime")String worEndTime);
	
}
