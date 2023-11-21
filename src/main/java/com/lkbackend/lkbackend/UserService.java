package com.lkbackend.lkbackend;

public class UserService {
	
	private UserRepository userRepository;
	
	public User findUser(String phoneNumber) {
		User user = userRepository.findByPhoneNumber(phoneNumber);
		return user;
	}
	
	public User insertUser(String phoneNumber, String panNumber) {
		User user = new User(phoneNumber, panNumber);
		userRepository.save(user);
		return user;
	}

}
