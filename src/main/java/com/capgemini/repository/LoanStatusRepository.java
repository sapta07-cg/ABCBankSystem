package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.LoanStatus;

public interface LoanStatusRepository extends JpaRepository<LoanStatus, Integer>{

}
