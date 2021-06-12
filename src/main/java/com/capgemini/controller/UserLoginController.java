package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.UserLogin;
import com.capgemini.exception.UserLoginException;
import com.capgemini.service.IUserLoginService;

@CrossOrigin
@RestController
@RequestMapping("/api/Login")
public class UserLoginController {
	
	@Autowired
	IUserLoginService iUserLoginService;
	
	@GetMapping("/LadLogin")
	public ResponseEntity<String> LadLogin(@RequestBody UserLogin user) throws UserLoginException {
		String str = iUserLoginService.LadLogin(user);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@PostMapping("/AdminLogin")
	public ResponseEntity<String> AdminLogin(@RequestBody UserLogin user) throws UserLoginException {
		String str = iUserLoginService.AdminLogin(user);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	
	@DeleteMapping("/LadLogout")
	public ResponseEntity<String> LadLogout(@RequestBody UserLogin user) throws UserLoginException {
		String string = iUserLoginService.LadLogout(user);
		return new ResponseEntity<String>(string, HttpStatus.OK);
	}
	
	@DeleteMapping("/AdminLogout")
	public ResponseEntity<String> AdminLogout(@RequestBody UserLogin user) throws UserLoginException {
		String string = iUserLoginService.AdminLogout(user);
		return new ResponseEntity<String>(string, HttpStatus.OK);
	}

}
