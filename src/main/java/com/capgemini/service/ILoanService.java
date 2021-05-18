package com.capgemini.service;

import com.capgemini.entities.LoanProgram;

public interface ILoanService {
	public String addLoanDetails(LoanProgram loanprogram);
	public String updateLoanDetails(int loanid,LoanProgram loanprogram);
	public String deleteLoanDetails(int loanid);

}
