package com.lkbackend.lkbackend.Entity;

import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentURL {
    private String panCard;
    private String bankStatementOne;
    private String bankStatementTwo;
    private String bankStatementThree;
    private String bankStatementFour;
    private String bankStatementFive;
    private String businessRegistrationProof;
    private String businessAddressProof;
    private String idProofOfGuarantor;
    public DocumentURL(DocumentUploadDetails res) {
        setBankStatementOne(res.getBankStatementOne());
        setBankStatementTwo(res.getBankStatementTwo());
        setBankStatementThree(res.getBankStatementThree());
        setBankStatementFour(res.getBankStatementFour());
        setBankStatementFive(res.getBankStatementFive());

        setIdProofOfGuarantor(res.getIdProofOfGuarantor());
        setPanCard(res.getPanCard());
        setBusinessAddressProof(res.getBusinessAddressProof());
        setBusinessRegistrationProof(res.getBusinessRegistrationProof());
    }
}

