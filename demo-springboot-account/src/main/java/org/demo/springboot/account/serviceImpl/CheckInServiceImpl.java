package org.demo.springboot.account.serviceImpl;

import java.util.List;

import org.demo.springboot.account.dto.CheckInDTO;
import org.demo.springboot.account.mapper.CheckInMapper;
import org.demo.springboot.account.service.CheckInService;
import org.demo.springboot.base.pojo.Page;
import org.demo.springboot.base.utils.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInServiceImpl implements CheckInService {
		
	@Autowired
	private CheckInMapper checkInMapper;
	
	@Override
	public List<CheckInDTO> queryAllcheckInData(Page page) {
		return checkInMapper.queryAllcheckInData(PageMethod.getRowBounds(page));
	}
	
	@Override
	public Boolean checkIn(CheckInDTO checkIn) {
		return checkInMapper.insert(checkIn) == 1 ? true : false;
	}
	
}
