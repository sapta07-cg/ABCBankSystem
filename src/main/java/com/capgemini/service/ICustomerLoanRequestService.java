package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.CustomerLoanRequest;

public interface ICustomerLoanRequestService {
	public String addCustomerLoanRequest(CustomerLoanRequest customerLoanRequest);

	public String updateCustomerLoanRequest(int id, CustomerLoanRequest customerLoanRequest);

	public String deleteCustomerLoanRequest(int id);
	
	public CustomerLoanRequest findById(int id);
	
	public List<CustomerLoanRequest> findAllRecords();

}
