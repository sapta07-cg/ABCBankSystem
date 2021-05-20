package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.CustomerLoanRequest;
import com.capgemini.exception.CustomerLoanRequestNotFoundException;
import com.capgemini.service.ICustomerLoanRequestService;

@RestController
@RequestMapping("/api/customerloanrequest/")
public class CustomerLoanRequestController {
	
	
	
	
	@Autowired
	ICustomerLoanRequestService icustomerloanrequestservice;
	
	@PostMapping("/addloandetails")
	public ResponseEntity<String> createloandetails(@RequestBody CustomerLoanRequest customerLoanRequest) {
		icustomerloanrequestservice.addCustomerLoanRequest(customerLoanRequest);
		return new ResponseEntity<>("Added", HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateloandetails(@PathVariable int id,@RequestBody CustomerLoanRequest customerLoanRequest) throws CustomerLoanRequestNotFoundException {
		icustomerloanrequestservice.updateCustomerLoanRequest(id, customerLoanRequest);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLoandetails(@PathVariable int id) {
		icustomerloanrequestservice.deleteCustomerLoanRequest(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	//find customer by id
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerLoanRequest> findById(@PathVariable int id) {
		CustomerLoanRequest clr = icustomerloanrequestservice.findById(id);
		return new ResponseEntity<CustomerLoanRequest>(clr, HttpStatus.OK);
	}
	
	
	

}
