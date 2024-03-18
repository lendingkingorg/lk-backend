package com.lkbackend.lkbackend.Entity;

import com.lkbackend.lkbackend.model.BLDocumentUploadDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentURL {
    private String PanCard;
    private String BankStatementOne;
    private String BankStatementTwo;
    private String BankStatementThree;
    private String BankStatementFour;
    private String BankStatementFive;
    private String BusinessRegistrationProof;
    private String BusinessAddressProof;
    private String IDProofOfGuarantor;
    public DocumentURL(BLDocumentUploadDetails res) {
        setBankStatementOne(res.getBankStatementOne());
        setBankStatementTwo(res.getBankStatementTwo());
        setBankStatementThree(res.getBankStatementThree());
        setBankStatementFour(res.getBankStatementFour());
        setBankStatementFive(res.getBankStatementFive());

        setIDProofOfGuarantor(res.getIdProofOfGuarantor());
        setPanCard(res.getPanCard());
        setBusinessAddressProof(res.getBusinessAddressProof());
        setBusinessRegistrationProof(res.getBusinessRegistrationProof());
    }
}

