package com.capgemini.service;

import com.capgemini.entities.UserRegister;
import com.capgemini.exception.UserRegisterException;

public interface IUserRegisterService {
	public String AdminRegistration(UserRegister register) throws UserRegisterException;
	public String LadRegistration(UserRegister register) throws UserRegisterException;

}
