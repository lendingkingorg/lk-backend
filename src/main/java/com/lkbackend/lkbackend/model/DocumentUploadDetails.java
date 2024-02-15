package com.lkbackend.lkbackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "document_inf")
@Getter
@Setter
public class DocumentUploadDetails {

    @Id
    private Long mobileNo;
    private String PanCardUrl;

    private String BankStatementUrlOne;
    private String BankInfoOne;
    private String BankStatementOneDocFormat;

    private String BankStatementUrlTwo;
    private String BankInfoTwo;
    private String BankStatementTwoDocFormat;

    private String BankStatementUrlThree;
    private String BankInfoThree;
    private String BankStatementThreeDocFormat;

    private String BankStatementUrlFour;
    private String BankInfoFour;
    private String BankStatementFourDocFormat;

    private String BankStatementUrlFive;
    private String BankInfoFive;
    private String BankStatementFiveDocFormat;

    private String BusinessRegistrationProofUrl;

   private String BusinessAddressProofUrl;

    private String IDProofOfGuarantorUrl;


}
