package com.lkbackend.lkbackend.Service;


import com.amazonaws.services.s3.AmazonS3;
import com.lkbackend.lkbackend.Entity.ApplicationCentralBinDTO;
import com.lkbackend.lkbackend.Repo.ApplicationCentralBinRepo;
import com.lkbackend.lkbackend.Repo.LoanApplicationRepository;
import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.Repo.DocumentRepository;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class BusinessEngineServiceImpl implements BusinessEngineServiceInterface{
    @Autowired
    private AmazonS3 s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    LoanApplicationRepository loanApplicationRepository;
    @Autowired
    ApplicationCentralBinRepo applicationCentralBinRepo;
    @Override
    public void getPayLoad(Long mobNo) {
        DocumentUploadDetails urlDetails= documentRepository.findByMobileNo(mobNo);
        log.info("Retrieved document upload details for mobile number: {}", mobNo);
    }

    private ApplicationCentralBinDTO saveIntoCentralBin(Long mobNo) {
        try {
            Optional<DocumentUploadDetails> urlDetailsOpt = Optional.ofNullable(documentRepository.findByMobileNo(mobNo));
            Optional<LoanApplicationDetails> applicantDetailsOpt = Optional.ofNullable(loanApplicationRepository.findByMobileNo(mobNo));

            if (urlDetailsOpt.isEmpty() && applicantDetailsOpt.isEmpty()) {
                log.warn("No document upload details and loan application details found for mobile number: {}", mobNo);
                // Log or handle the case where both are empty, if needed
                return null;
            }

            ApplicationCentralBin application = new ApplicationCentralBin(
                    urlDetailsOpt.orElse(null),
                    applicantDetailsOpt.orElse(null),
                    mobNo
            );

            ApplicationCentralBin res = applicationCentralBinRepo.save(application);
            log.info("Saved application into central bin with ID: {}", res.getApplicationID());
            return new ApplicationCentralBinDTO(res.getApplicationID(), res.getRequestedLoanAmount(), res.getCreatedAt());
            // Optionally, you can log or handle success here.
        } catch (Exception e) {
            log.error("Failed to save data to central bin for mobile number: {}", mobNo, e);
            // Log or handle the exception.
            throw new RuntimeException("Failed to save data to central bin for mobile number: " + mobNo, e);
        }
    }



    @Override
    public ApplicationCentralBinDTO runBusinessEngine(Long mobNo) {
        log.info("Business engine executed successfully for mobile number: {}", mobNo);
        return saveIntoCentralBin(mobNo);
    }


}
