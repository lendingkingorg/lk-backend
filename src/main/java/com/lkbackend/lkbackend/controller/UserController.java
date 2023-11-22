package com.lkbackend.lkbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.lkbackend.lkbackend.model.User;
import com.lkbackend.lkbackend.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(@RequestHeader(value="phoneNumber") String phoneNumber) {
		System.out.println("get User API Triggered");
		User user = userService.findUser(phoneNumber);
		
		if(user == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestHeader(value="phoneNumber") String phoneNumber,
										@RequestHeader(value="panNumber") String panNumber,
										@RequestHeader(value="mPin") String mPin,
										@RequestHeader(value="emailID") String emailID) {
		System.out.println("Add User API Triggered");
		User user = userService.insertUser(phoneNumber, panNumber, mPin, emailID);
		return ResponseEntity.ok(user);
	}

}
