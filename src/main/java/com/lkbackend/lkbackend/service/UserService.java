package com.lkbackend.lkbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkbackend.lkbackend.model.User;
import com.lkbackend.lkbackend.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	
	public User findUser(String phoneNumber) {
		User user = userRepository.findByPhoneNumber(phoneNumber);
		return user;
	}
	
	public User insertUser(String phoneNumber, String panNumber, String mPin, String emailID) {
		User user = new User(phoneNumber, panNumber, mPin, emailID);
		userRepository.save(user);
		return user;
	}

}