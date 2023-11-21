package com.lkbackend.lkbackend;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String phoneNumber;
	
	@NotNull
	private String panNumber;
	
	public User(String phoneNumber, String panNumber) {
		super();
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	

}
