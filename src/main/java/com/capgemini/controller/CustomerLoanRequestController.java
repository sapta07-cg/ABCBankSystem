package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class CustomerLoanRequestController {
	
	
	
	
	@Autowired
	ICustomerLoanRequestService iCustomerLoanRequestService;
	
	@PostMapping("/addloandetails")
	public ResponseEntity<String> createloandetails(@RequestBody CustomerLoanRequest customerLoanRequest) {
		iCustomerLoanRequestService.addCustomerLoanRequest(customerLoanRequest);
		return new ResponseEntity<>("Added", HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateloandetails(@PathVariable int id,@RequestBody CustomerLoanRequest customerLoanRequest) throws CustomerLoanRequestNotFoundException {
		iCustomerLoanRequestService.updateCustomerLoanRequest(id, customerLoanRequest);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLoandetails(@PathVariable int id) {
		iCustomerLoanRequestService.deleteCustomerLoanRequest(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	//find customer by id
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerLoanRequest> findById(@PathVariable int id) {
		CustomerLoanRequest clr = iCustomerLoanRequestService.findById(id);
		return new ResponseEntity<CustomerLoanRequest>(clr, HttpStatus.OK);
	}
	@GetMapping("/allcustomerrecords")
	public List<CustomerLoanRequest> allrecords() {
		return iCustomerLoanRequestService.findAllRecords();
	}
	
	
	

}
