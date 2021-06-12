package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.UserLogin;
import com.capgemini.entities.UserRegister;
import com.capgemini.exception.UserLoginException;
import com.capgemini.repository.UserLoginRepository;
import com.capgemini.repository.UserRegisterRepository;

@Service
public class UserLoginServiceImpl implements IUserLoginService{
	
	@Autowired
	private UserLoginRepository userLoginRepository;

	@Autowired
	private UserRegisterRepository userRegisterRepository;

	@Override
	public String LadLogin(UserLogin user) throws UserLoginException {
		if (!userRegisterRepository.existsById(user.getUserId())) {
			throw new UserLoginException("UserId Invalid");
		}
		
		UserRegister dbUser = userRegisterRepository.findById(user.getUserId()).get();

		if (!dbUser.getPassword().equals(user.getPassword())) {
			throw new UserLoginException("Incorrect Password");
		}

		userLoginRepository.save(user);

		return "Login Successful";
	}

	@Override
	public String AdminLogin(UserLogin user) throws UserLoginException {
		if (!userRegisterRepository.existsById(user.getUserId())) {
			throw new UserLoginException("UserId Invalid");
		}
		
		UserRegister dbUser = userRegisterRepository.findById(user.getUserId()).get();


		if (!dbUser.getPassword().equals(user.getPassword())) {
			throw new UserLoginException("Incorrect Password");
		}

		userLoginRepository.save(user);

		return "Admin Login Successful";
	}

	@Override
	public String LadLogout(UserLogin user) throws UserLoginException {
		if (!userLoginRepository.existsById(user.getUserId())) {
			throw new UserLoginException("UserId Invalid");
		}
		
		UserLogin dbUser = userLoginRepository.findById(user.getUserId()).get();

	

		if (!dbUser.getPassword().equals(user.getPassword())) {
			throw new UserLoginException("Incorrect Password");
		}

		userLoginRepository.delete(dbUser);

		return "Logout Successful";
	}

	@Override
	public String AdminLogout(UserLogin user) throws UserLoginException {
		if (!userLoginRepository.existsById(user.getUserId())) {
			throw new UserLoginException("UserId Invalid");
		}
		
		UserLogin dbUser = userLoginRepository.findById(user.getUserId()).get();


		if (!dbUser.getPassword().equals(user.getPassword())) {
			throw new UserLoginException("Incorrect Password");
		}

		userLoginRepository.delete(dbUser);

		return "Admin Logout Successful";
	}
	}

