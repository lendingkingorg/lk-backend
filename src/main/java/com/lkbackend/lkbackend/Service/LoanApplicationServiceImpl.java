package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;
import com.lkbackend.lkbackend.Repo.DocumentRepository;
import com.lkbackend.lkbackend.Repo.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationServiceInterface {


    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private DocumentRepository documentRepository;
    public LoanApplicationDetails saveLoanApplication(LoanApplicationDetails loanApplication) {
        LoanApplicationDetails save = loanApplicationRepository.save(loanApplication);
        return save;
    }

    public Boolean docUploadStatus(Long mobNo){

        return loanApplicationRepository.existsById(mobNo);

    }
    public DocumentUploadDetails uploadStatus(long mobNo){

        return documentRepository.findByMobileNo(mobNo);
    }
}
