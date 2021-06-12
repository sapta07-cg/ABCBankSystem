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

import com.capgemini.entities.LoanProgram;
import com.capgemini.service.ILoanService;

@RestController
@RequestMapping("api/admin/")
@CrossOrigin
public class AdminController {
	
	@Autowired
	ILoanService iLoanService;
	
	@PostMapping("/addloandetails")
	public ResponseEntity<String> createloandetails(@RequestBody LoanProgram loanprogram) {
		iLoanService.addLoanDetails(loanprogram);
		return new ResponseEntity<>("Added", HttpStatus.CREATED);
	}
	
	@PutMapping("/{loanid}")
	public ResponseEntity<String> updateloandetails(@PathVariable int loanid,@RequestBody LoanProgram loanprogram)  {
		iLoanService.updateLoanDetails(loanid, loanprogram);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/{loanid}")
	public ResponseEntity<String> deleteloandetails(@PathVariable int loanid) {
		iLoanService.deleteLoanDetails(loanid);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<LoanProgram> findById(@PathVariable int id) {
		LoanProgram lp = iLoanService.findById(id);
		return new ResponseEntity<LoanProgram>(lp, HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<LoanProgram>> findAll() {
		List<LoanProgram> list = iLoanService.findAll();
		return new ResponseEntity<List<LoanProgram>>(list, HttpStatus.OK);
	}

}
