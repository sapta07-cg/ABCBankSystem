package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer>{

}
