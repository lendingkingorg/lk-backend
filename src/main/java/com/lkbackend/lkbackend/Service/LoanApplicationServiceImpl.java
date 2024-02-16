package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;
import com.lkbackend.lkbackend.Repo.DocumentRepository;
import com.lkbackend.lkbackend.Repo.LoanApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoanApplicationServiceImpl implements LoanApplicationServiceInterface {
    @Autowired
    private LoanApplicationRepository loanApplicationRepository;
    @Autowired
    private DocumentRepository documentRepository;

    public LoanApplicationDetails saveLoanApplication(LoanApplicationDetails loanApplication) {
        log.info("Saving loan application details: {}", loanApplication);
        LoanApplicationDetails save = loanApplicationRepository.save(loanApplication);
        return save;
    }
    public Boolean docUploadStatus(Long mobNo) {
        log.info("Checking document upload status for mobile number: {}", mobNo);
        return loanApplicationRepository.existsById(mobNo);
    }
    public DocumentUploadDetails uploadStatus(long mobNo) {
        log.info("Fetching document upload details for mobile number: {}", mobNo);
        return documentRepository.findByMobileNo(mobNo);
    }
}
