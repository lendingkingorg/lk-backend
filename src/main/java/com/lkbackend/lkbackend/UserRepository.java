package com.lkbackend.lkbackend;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByPhoneNumber(String phoneNumber);

}
