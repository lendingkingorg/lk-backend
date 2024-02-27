package com.lkbackend.lkbackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "application_central_bin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationCentralBin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationID;  // Add applicationID as the primary key
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
    private String pan;

    // Financial Information
    @Column(name = "annual_turnover")
    private String annualTurnover;
    @Column(name ="years_in_current_business" )
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
    @Column(name ="nature_of_business" )
    private String natureOfBusiness;
    @Column(name = "business_run_by")
    private String businessRunBy;

    // Loan Request Information
    @Column(name = "requested_loan_amount")
    private double requestedLoanAmount;
    @Column(name = "loan_duration_in_months")
    private int loanDurationInMonths;
    @Column(name = "pan_card_url")
    private String panCardUrl;
    @Column(name = "bank_statement_url_one")
    private String bankStatementUrlOne;
    @Column(name = "bank_info_one")
    private String bankInfoOne;
    @Column(name = "bank_statement_one_doc_format")
    private String bankStatementOneDocFormat;
    @Column(name = "bank_statement_url_two")
    private String bankStatementUrlTwo;
    @Column(name = "bank_info_two")
    private String bankInfoTwo;
    @Column(name = "bank_statement_two_doc_format")
    private String bankStatementTwoDocFormat;
    @Column(name = "bank_statement_url_three")
    private String bankStatementUrlThree;
    @Column(name = "bank_info_three")
    private String bankInfoThree;
    @Column(name = "bank_statement_three_doc_format")
    private String bankStatementThreeDocFormat;
    @Column(name = "bank_statement_url_four")
    private String bankStatementUrlFour;
    @Column(name = "bank_info_four")
    private String bankInfoFour;
    @Column(name = "bank_statement_four_doc_format")
    private String bankStatementFourDocFormat;
    @Column(name = "bank_statement_url_five")
    private String bankStatementUrlFive;
    @Column(name = "bank_info_five")
    private String bankInfoFive;
    @Column(name = "bank_statement_five_doc_format")
    private String bankStatementFiveDocFormat;
    @Column(name = "business_registration_proof_url")
    private String businessRegistrationProofUrl;
    @Column(name = "business_address_proof_url")
    private String businessAddressProofUrl;
    @Column(name = "id_proof_of_guarantor_url")
    private String idProofOfGuarantorUrl;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    private String applicationType;

    public ApplicationCentralBin(
            BLDocumentUploadDetails urlDetails,
            BLApplicationDetails applicantDetails,
            long mobNo,
            String applicationType
    ) {
        this.mobileNo = mobNo;
        this.applicationType = applicationType;
        if (applicationType.equals("BLApplication")) {
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
                this.idProofOfGuarantorUrl = urlDetails.getIdProofOfGuarantorUrl();
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
        } else if (applicationType.equals("PLApplication")) {

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


}
