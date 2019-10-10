package com.cg.demosecurity.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.demosecurity.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByUserName(String userName);

}
