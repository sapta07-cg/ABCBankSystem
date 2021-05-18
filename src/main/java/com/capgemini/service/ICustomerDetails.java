package com.capgemini.service;

import com.capgemini.entities.CustomerDetails;

public interface ICustomerDetails {
	public String addCustomerDetails(CustomerDetails customerdetails);
	public String updateCustomerDetails(int id, CustomerDetails customerDetails);
	public String deleteCustomerDetails(int id);

}
