package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.LoanProgram;
import com.capgemini.exception.Loannotfoundexception;
import com.capgemini.repository.LoanProgramRepository;

@Service
public class ILoanServiceimpl implements ILoanService{
	
	@Autowired
	LoanProgramRepository loanProgramRepository;

	@Override
	public String addLoanDetails(LoanProgram loanProgram) {
		loanProgramRepository.save(loanProgram);
		return "loan details added!!";
	}

	@Override
	public String updateLoanDetails(int loanid, LoanProgram loanprogram) {
		//if(!loanprogramrepository.existsById(loanid)) {
			//throw new LoannotfoundException("Check the id and Try again");
		//}
		LoanProgram ld=loanProgramRepository.findById(loanid).get();
		ld.setLoanType(loanprogram.getLoanType());
		ld.setMaximumAge(loanprogram.getMaximumAge());
		ld.setMinimumAge(loanprogram.getMinimumAge());
		loanProgramRepository.save(ld);
		
		return "Loan_details updated";
	}

	@Override
	public String deleteLoanDetails(int loanId) {
		loanProgramRepository.deleteById(loanId);
		return "Record deleted";
	}

	@Override
	public LoanProgram findById(int id){
		if (!loanProgramRepository.existsById(id)) {
			throw new Loannotfoundexception(" Loan program Not Found");
		}
		LoanProgram ls = loanProgramRepository.findById(id).get();
		return ls;
	}

	@Override
	public List<LoanProgram> findAll() {
		return loanProgramRepository.findAll();
	}

}
