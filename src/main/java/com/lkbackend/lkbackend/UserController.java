package com.lkbackend.lkbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/getUser")
	public User getUser(@RequestHeader(value="phoneNumber") String phoneNumber) {
		System.out.println("reached Here");
		User user = userService.findUser(phoneNumber);
		
		if(user == null)
			return null;
		return user;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestHeader(value="phoneNumber") String phoneNumber,
										@RequestHeader(value="panNumber") String panNumber) {
		System.out.println("reached Here");
		User user = userService.insertUser(phoneNumber, panNumber);
		return ResponseEntity.ok(user);
	}

}
