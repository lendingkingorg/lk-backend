package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;


public interface LoanApplicationServiceInterface {

    public LoanApplicationDetails saveLoanApplication(LoanApplicationDetails loanApplication);

    public DocumentUploadDetails uploadStatus(long mobNo);

    Boolean docUploadStatus(Long mobNo);
}
