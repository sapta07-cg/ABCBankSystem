package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.LoanProgram;

public interface ILoanService {
	public String addLoanDetails(LoanProgram loanProgram);
	public String updateLoanDetails(int loanId,LoanProgram loanProgram);
	public String deleteLoanDetails(int loanId);
	public LoanProgram findById(int id);
	public List<LoanProgram> findAll();

}
