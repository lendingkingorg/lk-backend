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
    private String PanCardUrl;
    private String BankStatementUrlOne;
    private String BankStatementUrlTwo;
    private String BankStatementUrlThree;
    private String BankStatementUrlFour;
    private String BankStatementUrlFive;
    private String BusinessRegistrationProofUrl;
    private String BusinessAddressProofUrl;
    private String IDProofOfGuarantorUrl;
    public DocumentURL(BLDocumentUploadDetails res) {
        setBankStatementUrlOne(res.getBankStatementUrlOne());
        setBankStatementUrlTwo(res.getBankStatementUrlTwo());
        setBankStatementUrlThree(res.getBankStatementUrlThree());
        setBankStatementUrlFour(res.getBankStatementUrlFour());
        setBankStatementUrlFive(res.getBankStatementUrlFive());

        setIDProofOfGuarantorUrl(res.getIdProofOfGuarantorUrl());
        setPanCardUrl(res.getPanCardUrl());
        setBusinessAddressProofUrl(res.getBusinessAddressProofUrl());
        setBusinessRegistrationProofUrl(res.getBusinessRegistrationProofUrl());
    }
}

