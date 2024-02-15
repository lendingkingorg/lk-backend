package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;


public interface LoanApplicationServiceInterface {

    LoanApplicationDetails saveLoanApplication(LoanApplicationDetails loanApplication);

    DocumentUploadDetails uploadStatus(long mobNo);

    Boolean docUploadStatus(Long mobNo);
}
