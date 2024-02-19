package com.lkbackend.lkbackend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "document_inf")
@Getter
@Setter
public class DocumentUploadDetails {

    @Id
    @Column(name = "mobile_no")
    private Long mobileNo;

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

}
