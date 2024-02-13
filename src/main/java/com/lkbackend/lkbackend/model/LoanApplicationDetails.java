package com.lkbackend.lkbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "loan_inf")
public class LoanApplicationDetails {

    @Id
    private Long mobileNo;

    // Personal Information
    private String name;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dob;
    private String gender;

    // Residential Information
    private String residentialPincode;
    private String residentialAddress;

    // PAN Information
    private String pan;

    // Financial Information
    private String annualTurnover;
    private String yearsInCurrentBusiness;

    // Business Information
    private String businessPincode;
    private String businessAddress;
    private String businessRegisteredAs;
    private String productCategory;
    private String natureOfBusiness;
    private String businessRunBy;

    // Loan Request Information
    private double requestedLoanAmount;
    private int loanDurationInMonths;


}

