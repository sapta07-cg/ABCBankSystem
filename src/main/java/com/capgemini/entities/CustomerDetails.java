package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	private int age;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private String city;
	private String state;
	private String nationality;
	private String pan_number;
	

}
