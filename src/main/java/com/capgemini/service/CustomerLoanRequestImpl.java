package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.entities.CustomerLoanRequest;
import com.capgemini.exception.CustomerLoanRequestNotFoundException;
import com.capgemini.repository.CustomerLoanRequestRepository;

public class CustomerLoanRequestImpl implements ICustomerLoanRequestService{
	
	@Autowired
	CustomerLoanRequestRepository customerLoanRequestRepository;

	@Override
	public String addCustomerLoanRequest(CustomerLoanRequest customerLoanRequest) {
		customerLoanRequestRepository.save(customerLoanRequest);
		return "CustomerLoanRequest is Added Sucessfully ";
	}

	@Override
	public String updateCustomerLoanRequest(int id, CustomerLoanRequest customerLoanRequest) {
		if (!customerLoanRequestRepository.existsById(id)) {
			throw new CustomerLoanRequestNotFoundException("Check the id and Try again");
		}

		CustomerLoanRequest ld = customerLoanRequestRepository.findById(id).get();
		ld.setId(customerLoanRequest.getId());
		customerLoanRequestRepository.save(ld);

		return "Customer Details Added!";
	}

	@Override
	public String deleteCustomerLoanRequest(int id) {
		customerLoanRequestRepository.deleteById(id);
		return "Record Deleted Sucessfully";
	}

}
