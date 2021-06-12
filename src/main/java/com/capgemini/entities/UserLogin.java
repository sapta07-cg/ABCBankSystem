package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
public class UserLogin {
	@Id
	@Column(nullable = false, unique = true)
	private String userId;

	@Column(nullable = false)
	private String password;

}
