package com.jk.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jk.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{
	
	public User getUserByEmail(int id); 
	
}
