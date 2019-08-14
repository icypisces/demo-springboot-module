package org.demo.springboot.account.dao;

import org.demo.springboot.account.dto.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountDAO extends JpaRepository<AccountDTO, Long> {
	
	@Query(nativeQuery = true, value = "SELECT id FROM account WHERE user_name =:username AND password =:password")
    public long getId(@Param("username") String username, @Param("password") String password);
	
	@Query(nativeQuery = true, value = "SELECT * FROM account WHERE id =:id")
	public AccountDTO queryUserInfo(@Param("id") Long id);
	
	
	@Query(nativeQuery = true, value = "SELECT count(1) FROM account WHERE user_name =:username")
	public int checkUsernameExist(@Param("username") String username);
}
