package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.UserRegister;
import com.capgemini.exception.UserRegisterException;
import com.capgemini.repository.UserRegisterRepository;

@Service
public class UserRegisterServiceImpl implements IUserRegisterService{
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;

	@Override
	public String AdminRegistration(UserRegister register) throws UserRegisterException {
		if (userRegisterRepository.existsById(register.getEmail())) {
			throw new UserRegisterException("Email already Exist");
		}
		if (!(register.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))) {
			throw new UserRegisterException("Give valid Email");
		}
		if (!(register.getPassword().matches("^[A-Za-z0-9@.*#$!]{6,10}$"))) {
			throw new UserRegisterException("Give valid password");

		}

		userRegisterRepository.save(register);
		return "Registration Successful";
	}

	@Override
	public String LadRegistration(UserRegister register) throws UserRegisterException {
		if (userRegisterRepository.existsById(register.getEmail())) {
			throw new UserRegisterException("Email already Exist");
		}
		if (!(register.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))) {
			throw new UserRegisterException("Give valid Email");
		}
		if (!(register.getPassword().matches("^[A-Za-z0-9@.*#$!]{6,10}$"))) {
			throw new UserRegisterException("Give valid password");

		}

		userRegisterRepository.save(register);
		return "User Registration Successful";
	}
	}


