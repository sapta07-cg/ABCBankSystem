package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.LoanProgram;
import com.capgemini.repository.LoanProgramRepository;

@Service
public class ILoanServiceimpl implements ILoanService{
	
	@Autowired
	LoanProgramRepository loanprogramrepository;

	@Override
	public String addLoanDetails(LoanProgram loanprogram) {
		loanprogramrepository.save(loanprogram);
		return "loan details added!!";
	}

	@Override
	public String updateLoanDetails(int loanid, LoanProgram loanprogram) {
		//if(!loanprogramrepository.existsById(loanid)) {
			//throw new LoannotfoundException("Check the id and Try again");
		//}
		LoanProgram ld=loanprogramrepository.findById(loanid).get();
		ld.setLoantype(loanprogram.getLoantype());
		loanprogramrepository.save(ld);
		
		return "Loan_details updated";
	}

	@Override
	public String deleteLoanDetails(int loanid) {
		loanprogramrepository.deleteById(loanid);
		return "Record deleted";
	}

}
