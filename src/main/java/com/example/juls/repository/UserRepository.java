package com.example.juls.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.juls.model.Users;


public interface UserRepository extends JpaRepository<Users, Integer>{
	public Users findByUsername(String username);
}
