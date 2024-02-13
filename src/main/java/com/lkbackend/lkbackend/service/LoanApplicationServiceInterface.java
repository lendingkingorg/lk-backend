package com.lkbackend.lkbackend.service;

import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;


public interface LoanApplicationServiceInterface {

    public LoanApplicationDetails saveLoanApplication(LoanApplicationDetails loanApplication);

    public DocumentUploadDetails uploadStatus(long mobNo);

    Boolean docUploadStatus(Long mobNo);
}
