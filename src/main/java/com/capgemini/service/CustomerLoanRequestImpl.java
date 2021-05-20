package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.CustomerLoanRequest;
import com.capgemini.exception.CustomerLoanRequestNotFoundException;
import com.capgemini.repository.CustomerLoanRequestRepository;
@Service
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
		//ld.setId(customerLoanRequest.getId());
		if(customerLoanRequest.getCity()!=null) {
		ld.setCity(customerLoanRequest.getCity());
		}
		
		customerLoanRequestRepository.save(ld);

		return "Customer Details updated!";
	}

	@Override
	public String deleteCustomerLoanRequest(int id) {
		customerLoanRequestRepository.deleteById(id);
		return "Record Deleted Sucessfully";
	}

	@Override
	public CustomerLoanRequest findById(int id) {
		if (!customerLoanRequestRepository.existsById(id)) {
			throw new CustomerLoanRequestNotFoundException(" Custmor Loan Request Not Found");
		}
		CustomerLoanRequest cLR = customerLoanRequestRepository.findById(id).get();
		return cLR;
	}

}
