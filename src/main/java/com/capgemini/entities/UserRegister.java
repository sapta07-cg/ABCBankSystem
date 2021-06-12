package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
public class UserRegister {
	@Id
	private String email;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String userPan;

	@Column(nullable = false)
	private String userNumber;

	@Column(nullable = false)
	private String password;

}
