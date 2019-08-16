package org.demo.springboot.account.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.demo.springboot.account.dto.CheckInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CheckInService {
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity checkIn(HttpServletRequest request);

	public List<CheckInDTO> queryCheckInData(HttpServletRequest request);

}
