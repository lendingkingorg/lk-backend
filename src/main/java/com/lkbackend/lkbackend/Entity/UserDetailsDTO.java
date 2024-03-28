package com.lkbackend.lkbackend.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserDetailsDTO {

    private String name;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dob;
    private String gender;

    private String residentialPincode;
    private String residentialAddress;

    private String pan;
    private String gstNumber;

    private String annualTurnover;
    private String yearsInCurrentBusiness;

    private String businessPincode;
    private String businessAddress;
    private String businessRegisteredAs;
    private String productCategory;
    private String natureOfBusiness;
    private String businessRunBy;

    private double requestedLoanAmount;
    private int loanDurationInMonths;

    // Fields from LendingInfo

    private long mobileNumber;

    private String email;



}

