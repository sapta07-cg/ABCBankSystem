package com.capgemini.service;
import java.util.List;

import com.capgemini.entities.LoanStatus;

public interface ICustomerLoanReport {
	public String Lad(int id);
	public List<LoanStatus> findallrecord();
	public String deleteById(int id);

}
