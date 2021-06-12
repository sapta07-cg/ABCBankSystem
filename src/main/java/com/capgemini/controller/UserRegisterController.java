package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.UserRegister;
import com.capgemini.exception.UserRegisterException;
import com.capgemini.service.IUserLoginService;
import com.capgemini.service.IUserRegisterService;

@CrossOrigin
@RestController
@RequestMapping("/api/Registration")
public class UserRegisterController {
	
	@Autowired
	IUserRegisterService iUserRegisterService;
	
	@PostMapping("/LadRegistration")
	public ResponseEntity<String> LadRegistration(@RequestBody UserRegister register) throws UserRegisterException {
		String str = iUserRegisterService.LadRegistration(register);
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}
	
	@PostMapping("/AdminRegistration")
	public ResponseEntity<String> AdminRegistration(@RequestBody UserRegister register) throws UserRegisterException {
		String str = iUserRegisterService.AdminRegistration(register);
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

}
