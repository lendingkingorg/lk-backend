package com.lkbackend.lkbackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "application_central_bin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationCentralBin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationID;  // Add applicationID as the primary key

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

    private String panCardUrl;

    private String bankStatementUrlOne;
    private String bankInfoOne;
    private String bankStatementOneDocFormat;

    private String bankStatementUrlTwo;
    private String bankInfoTwo;
    private String bankStatementTwoDocFormat;

    private String bankStatementUrlThree;
    private String bankInfoThree;
    private String bankStatementThreeDocFormat;

    private String bankStatementUrlFour;
    private String bankInfoFour;
    private String bankStatementFourDocFormat;

    private String bankStatementUrlFive;
    private String bankInfoFive;
    private String bankStatementFiveDocFormat;

    private String businessRegistrationProofUrl;

    private String businessAddressProofUrl;

    private String idProofOfGuarantorUrl;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public ApplicationCentralBin(
            DocumentUploadDetails urlDetails,
            LoanApplicationDetails applicantDetails,
            long mobNo
    ) {
        this.mobileNo = mobNo;
        if (urlDetails != null) {

            this.panCardUrl = urlDetails.getPanCardUrl();
            this.bankStatementUrlOne = urlDetails.getBankStatementUrlOne();
            this.bankInfoOne = urlDetails.getBankInfoOne();
            this.bankStatementOneDocFormat = urlDetails.getBankStatementOneDocFormat();
            this.bankStatementUrlTwo = urlDetails.getBankStatementUrlTwo();
            this.bankInfoTwo = urlDetails.getBankInfoTwo();
            this.bankStatementTwoDocFormat = urlDetails.getBankStatementTwoDocFormat();
            this.bankStatementUrlThree = urlDetails.getBankStatementUrlThree();
            this.bankInfoThree = urlDetails.getBankInfoThree();
            this.bankStatementThreeDocFormat = urlDetails.getBankStatementThreeDocFormat();
            this.bankStatementUrlFour = urlDetails.getBankStatementUrlFour();
            this.bankInfoFour = urlDetails.getBankInfoFour();
            this.bankStatementFourDocFormat = urlDetails.getBankStatementFourDocFormat();
            this.bankStatementUrlFive = urlDetails.getBankStatementUrlFive();
            this.bankInfoFive = urlDetails.getBankInfoFive();
            this.bankStatementFiveDocFormat = urlDetails.getBankStatementFiveDocFormat();
            this.businessRegistrationProofUrl = urlDetails.getBusinessRegistrationProofUrl();
            this.businessAddressProofUrl = urlDetails.getBusinessAddressProofUrl();
            this.idProofOfGuarantorUrl = urlDetails.getIDProofOfGuarantorUrl();
        }

        if (applicantDetails != null) {
            this.name = applicantDetails.getName();
            this.dob = applicantDetails.getDob();
            this.gender = applicantDetails.getGender();
            this.residentialPincode = applicantDetails.getResidentialPincode();
            this.residentialAddress = applicantDetails.getResidentialAddress();
            this.pan = applicantDetails.getPan();
            this.annualTurnover = applicantDetails.getAnnualTurnover();
            this.yearsInCurrentBusiness = applicantDetails.getYearsInCurrentBusiness();
            this.businessPincode = applicantDetails.getBusinessPincode();
            this.businessAddress = applicantDetails.getBusinessAddress();
            this.businessRegisteredAs = applicantDetails.getBusinessRegisteredAs();
            this.productCategory = applicantDetails.getProductCategory();
            this.natureOfBusiness = applicantDetails.getNatureOfBusiness();
            this.businessRunBy = applicantDetails.getBusinessRunBy();
            this.requestedLoanAmount = applicantDetails.getRequestedLoanAmount();
            this.loanDurationInMonths = applicantDetails.getLoanDurationInMonths();
        }
    }

}
