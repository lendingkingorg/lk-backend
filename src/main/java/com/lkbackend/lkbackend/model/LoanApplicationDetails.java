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
    @Column(name = "mobile_no")
    private Long mobileNo;

    // Personal Information
    private String name;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String gender;

    // Residential Information
    @Column(name = "residential_pincode")
    private String residentialPincode;

    @Column(name = "residential_address")
    private String residentialAddress;

    // PAN Information
    @Column(name = "pan")
    private String pan;

    // Financial Information
    @Column(name = "annual_turnover")
    private String annualTurnover;

    @Column(name = "years_in_current_business")
    private String yearsInCurrentBusiness;

    // Business Information
    @Column(name = "business_pincode")
    private String businessPincode;

    @Column(name = "business_address")
    private String businessAddress;

    @Column(name = "business_registered_as")
    private String businessRegisteredAs;

    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "nature_of_business")
    private String natureOfBusiness;

    @Column(name = "business_run_by")
    private String businessRunBy;

    // Loan Request Information
    @Column(name = "requested_loan_amount")
    private double requestedLoanAmount;

    @Column(name = "loan_duration_in_months")
    private int loanDurationInMonths;

}
