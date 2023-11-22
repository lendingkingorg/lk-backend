package com.lkbackend.lkbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id	
	private String phoneNumber;
	
	private String panNumber;
	
	private String mPin;
	
	private String emailID;

	public User() {}
	
	public User(String phoneNumber, String panNumber, String mPin, String emailID) {
		super();
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
		this.mPin = mPin;
		this.emailID = emailID;
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

	public String getmPin() {
		return mPin;
	}

	public void setmPin(String mPin) {
		this.mPin = mPin;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	
	
	

}

