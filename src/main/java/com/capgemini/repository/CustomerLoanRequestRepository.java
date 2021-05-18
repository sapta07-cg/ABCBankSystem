package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.CustomerLoanRequest;

public interface CustomerLoanRequestRepository extends JpaRepository<CustomerLoanRequest, Integer>{

}
