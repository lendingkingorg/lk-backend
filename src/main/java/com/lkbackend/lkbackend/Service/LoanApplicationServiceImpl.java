package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.model.BLDocumentUploadDetails;
import com.lkbackend.lkbackend.model.BLApplicationDetails;
import com.lkbackend.lkbackend.Repo.BLDocumentRepository;
import com.lkbackend.lkbackend.Repo.BLApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoanApplicationServiceImpl implements LoanApplicationServiceInterface {
    @Autowired
    private BLApplicationRepository loanApplicationRepository;
    @Autowired
    private BLDocumentRepository documentRepository;

    public BLApplicationDetails saveLoanApplication(BLApplicationDetails loanApplication) {
        log.info("Saving loan application details: {}", loanApplication);
        BLApplicationDetails save = loanApplicationRepository.save(loanApplication);
        return save;
    }
    public Boolean docUploadStatus(Long mobNo) {
        log.info("Checking document upload status for mobile number: {}", mobNo);
        return loanApplicationRepository.existsById(mobNo);
    }
    public BLDocumentUploadDetails uploadStatus(long mobNo) {
        log.info("Fetching document upload details for mobile number: {}", mobNo);
        return documentRepository.findByMobileNo(mobNo);
    }
}
