package com.capgemini.service;

import com.capgemini.entities.UserLogin;
import com.capgemini.exception.UserLoginException;

public interface IUserLoginService {
public String LadLogin(UserLogin user) throws UserLoginException;
	
	public String AdminLogin(UserLogin user) throws UserLoginException;

	public String LadLogout(UserLogin user) throws UserLoginException;
	
	public String AdminLogout(UserLogin user) throws UserLoginException;

}
