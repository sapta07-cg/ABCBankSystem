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
import com.capgemini.repository.CustomerLoanRequestRepository;
import com.capgemini.service.CustomerLoanRequestImpl;

@RestController
@RequestMapping("/api/customerloanrequest/")
public class CustomerLoanRequestController {
	
	@Autowired
	CustomerLoanRequestImpl customerLoanRequestImpl;
	
	@Autowired
	CustomerLoanRequestRepository customerLoanRequestRepository;
	
	@PostMapping("/addloandetails")
	public ResponseEntity<String> createloandetails(@RequestBody CustomerLoanRequest customerLoanRequest) {
		customerLoanRequestImpl.addCustomerLoanRequest(customerLoanRequest);
		return new ResponseEntity<>("Added", HttpStatus.OK);
	}
	
	@PutMapping("/{customerid}")
	public ResponseEntity<String> updateloandetails(@PathVariable int id,
			@RequestBody CustomerLoanRequest customerLoanRequest) throws CustomerLoanRequestNotFoundException {
		customerLoanRequestImpl.updateCustomerLoanRequest(id, customerLoanRequest);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerid}")
	public ResponseEntity<String> deleteLoandetails(@PathVariable int id) {
		customerLoanRequestImpl.deleteCustomerLoanRequest(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	@GetMapping("/{customerid}")
	public ResponseEntity<CustomerLoanRequest> findById(@PathVariable int id) {
		CustomerLoanRequest clr = customerLoanRequestImpl.findById(id);
		return new ResponseEntity<CustomerLoanRequest>(clr, HttpStatus.OK);
	}
	
	
	

}
