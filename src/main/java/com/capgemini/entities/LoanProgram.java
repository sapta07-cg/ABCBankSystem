package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class LoanProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanid;
	private String loantype;
	private double maximaumage;
	private double minimumage;
}
