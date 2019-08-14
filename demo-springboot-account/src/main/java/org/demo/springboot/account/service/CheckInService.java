package org.demo.springboot.account.service;

import java.util.List;

import org.demo.springboot.account.dto.CheckInDTO;
import org.demo.springboot.base.pojo.Page;
import org.springframework.stereotype.Service;

@Service
public interface CheckInService {
	
	public List<CheckInDTO> queryAllcheckInData(Page page);
	
	public Boolean checkIn(CheckInDTO checkIn);
	

}
