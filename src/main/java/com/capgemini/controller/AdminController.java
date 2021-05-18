package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.LoanProgram;
import com.capgemini.repository.LoanProgramRepository;
import com.capgemini.service.ILoanService;

@RestController
@RequestMapping("api/admin/")
public class AdminController {
	@Autowired
	LoanProgramRepository loanprogramrepository;
	
	@Autowired
	ILoanService iloanservice;
	
	@PostMapping("/addloandetails")
	public ResponseEntity<String> createloandetails(@RequestBody LoanProgram loanprogram) {
		iloanservice.addLoanDetails(loanprogram);
		return new ResponseEntity<>("Added", HttpStatus.OK);
	}
	
	@PutMapping("/{loanid}")
	public ResponseEntity<String> updateloandetails(@PathVariable int id,@RequestBody LoanProgram loanprogram)  {
		iloanservice.updateLoanDetails(id, loanprogram);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/{loanid}")
	public ResponseEntity<String> deleteloandetails(@PathVariable int id) {
		iloanservice.deleteLoanDetails(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	

}
