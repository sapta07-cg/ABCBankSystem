package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.UserRegister;

public interface UserRegisterRepository extends JpaRepository<UserRegister, String>{

}
