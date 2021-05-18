package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.CustomerLoanRequest;
import com.capgemini.service.CustomerLoanRequestImpl;
import com.capgemini.service.ICustomerLoanReportImpl;

@RestController
@RequestMapping("api/lad/")
public class LADController {
	@Autowired
	ICustomerLoanReportImpl icustomerloanreportimpl;
	
	@GetMapping("/{id}")
	public ResponseEntity<String> checklad(@PathVariable int id) {
		icustomerloanreportimpl.hello(id);
		return new ResponseEntity<>("you got loan", HttpStatus.OK);
	}
	

}
