package com.lkbackend.lkbackend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bl_document_inf")
@Getter
@Setter
public class BLDocumentUploadDetails {

    @Id
    @Column(name = "mobile_no")
    private Long mobileNo;

    @Column(name = "pan_card")
    private String panCard;

    @Column(name = "bank_statement_one")
    private String bankStatementOne;

    @Column(name = "bank_info_one")
    private String bankInfoOne;

    @Column(name = "bank_statement_one_doc_format")
    private String bankStatementOneDocFormat;

    @Column(name = "bank_statement_two")
    private String bankStatementTwo;

    @Column(name = "bank_info_two")
    private String bankInfoTwo;

    @Column(name = "bank_statement_two_doc_format")
    private String bankStatementTwoDocFormat;

    @Column(name = "bank_statement_three")
    private String bankStatementThree;

    @Column(name = "bank_info_three")
    private String bankInfoThree;

    @Column(name = "bank_statement_three_doc_format")
    private String bankStatementThreeDocFormat;

    @Column(name = "bank_statement_four")
    private String bankStatementFour;

    @Column(name = "bank_info_four")
    private String bankInfoFour;

    @Column(name = "bank_statement_four_doc_format")
    private String bankStatementFourDocFormat;

    @Column(name = "bank_statement_five")
    private String bankStatementFive;

    @Column(name = "bank_info_five")
    private String bankInfoFive;

    @Column(name = "bank_statement_five_doc_format")
    private String bankStatementFiveDocFormat;

    @Column(name = "business_registration_proof")
    private String businessRegistrationProof;

    @Column(name = "business_address_proof")
    private String businessAddressProof;

    @Column(name = "id_proof_of_guarantor")
    private String idProofOfGuarantor;

}
