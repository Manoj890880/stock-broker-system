package com.stockman.service;

import com.stockman.exception.LoginException;
import com.stockman.model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

	public String logIntoAccountAdmin(LoginDTO dto)throws LoginException;
	
	public String logOutFromAccountAdmin(String key)throws LoginException;
}
