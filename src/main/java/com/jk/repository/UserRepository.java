package com.jk.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jk.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{
	@Query(value = "SELECT * FROM USER WHERE EMAIL=?1", nativeQuery = true)
	public List<User> getUserByEmail(String email); 	
}
