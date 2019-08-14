package org.demo.springboot.account.service;

import org.demo.springboot.account.dto.AccountDTO;
import org.demo.springboot.account.dto.LoginUserInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
	
	public Iterable<AccountDTO> list(Pageable pageable);
	
	public Boolean insert(AccountDTO account);
	
	public void delete(Long id);
	
	public LoginUserInfo signIn(String username, String password);
	
	public AccountDTO queryUserInfo(Long id);
	
	public Boolean checkUsernameExist(String username);

}
