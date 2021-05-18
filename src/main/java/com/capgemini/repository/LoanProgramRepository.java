package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.LoanProgram;

public interface LoanProgramRepository extends JpaRepository<LoanProgram, Integer>{

}
