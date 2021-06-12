package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {

}
