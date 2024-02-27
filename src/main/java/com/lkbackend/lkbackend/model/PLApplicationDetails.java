package com.lkbackend.lkbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "personal_loan_inf")
public class PLApplicationDetails {


    @Id
    @Column(name = "mobile_no")
    private Long mobileNo;


    private String employmentType;
    private String salaryBankAccount;
    private String employmentDetails;




    // Residential Information
    @Column(name = "residential_pincode")
    private String residentialPincode;

    @Column(name = "residential_address")
    private String residentialAddress;


    private String residentType;

    // Loan Request Information
    @Column(name = "requested_loan_amount")
    private double requestedLoanAmount;

    @Column(name = "loan_duration_in_months")
    private int loanDurationInMonths;




}
