package org.demo.springboot.account.serviceImpl;

import java.util.Date;

import org.demo.springboot.account.dao.AccountDAO;
import org.demo.springboot.account.dto.AccountDTO;
import org.demo.springboot.account.dto.LoginUserInfo;
import org.demo.springboot.account.mapper.AccountMapper;
import org.demo.springboot.account.service.AccountService;
import org.demo.springboot.account.utils.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AccountServiceImpl implements AccountService {
		
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public Iterable<AccountDTO> list(Pageable pageable) {
		return accountDAO.findAll(pageable);
//		return accountMapper.queryAllAccount();
	}
	
	@Override
	public Boolean insert(AccountDTO account) {
		return accountMapper.insert(account) == 1 ? true : false;
	}
	
	@Override
	public void delete(Long id) {
		accountMapper.delete(id);
//		accountDAO.deleteById(id);
	}
	
	@Override
	public LoginUserInfo signIn(String username, String password) {
		Long id = accountMapper.getId(username,password);
		LoginUserInfo loginUserDTO = new LoginUserInfo();
		if (id != null) {
			String jwt = 
					Jwts.builder()
								.setSubject(String.valueOf(id))
								.setExpiration(new Date(System.currentTimeMillis() + CommonConstant.EXPIRATION_TIME))
								.signWith(SignatureAlgorithm.HS512, CommonConstant.SECRET_KEY)
								.compact();
			loginUserDTO.setJwt(jwt);
			loginUserDTO.setUsername(username);
			loginUserDTO.setId(id);
		}
		return loginUserDTO;
	}
	
	@Override
	public AccountDTO queryUserInfo(Long id) {
		return accountMapper.queryUserInfo(id);
	}

	@Override
	public Boolean checkUsernameExist(String username) {
		return accountMapper.checkUsernameExist(username) > 0 ? true : false;
	}
	
}
