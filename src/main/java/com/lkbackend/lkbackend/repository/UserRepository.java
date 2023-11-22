package com.lkbackend.lkbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lkbackend.lkbackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByPhoneNumber(String phoneNumber);
}
