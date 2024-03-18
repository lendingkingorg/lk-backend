package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.model.BLDocumentUploadDetails;
import com.lkbackend.lkbackend.model.BLApplicationDetails;


public interface LoanApplicationServiceInterface {

    BLApplicationDetails saveLoanApplication(BLApplicationDetails loanApplication);

    BLDocumentUploadDetails uploadStatus(long mobNo);

    Boolean docUploadStatus(Long mobNo);
}
