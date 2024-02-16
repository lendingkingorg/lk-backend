package com.lkbackend.lkbackend.Service;


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
import software.amazon.awssdk.services.s3.S3Client;

@Service
@Slf4j
public class BusinessEngineServiceImpl implements BusinessEngineServiceInterface{
    @Autowired
    private S3Client s3Client;

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

    @Override
    public Long saveIntoCentralBin(Long mobNo) {
        try {

            DocumentUploadDetails urlDetails = documentRepository.findByMobileNo(mobNo);
            LoanApplicationDetails applicantDetails = loanApplicationRepository.findByMobileNo(mobNo);

            if (urlDetails == null && applicantDetails == null) {
                log.warn("No document upload details and loan application details found for mobile number: {}", mobNo);
                // Log or handle the case where both are null, if needed
                return null;
            }

            ApplicationCentralBin application = new ApplicationCentralBin(urlDetails, applicantDetails, mobNo);

            ApplicationCentralBin res=   applicationCentralBinRepo.save(application);
            log.info("Saved application into central bin with ID: {}", res.getApplicationID());
            return res.getApplicationID();
            // Optionally, you can log or handle success here.
        } catch (Exception e) {
            log.error("Failed to save data to central bin for mobile number: {}", mobNo, e);
            // Log or handle the exception.
            throw new RuntimeException("Failed to save data to central bin.", e);
        }
    }


    @Override
    public Long runBusinessEngine(Long mobNo) {
        Long ApplicationID = saveIntoCentralBin(mobNo);
        log.info("Business engine executed successfully for mobile number: {}", mobNo);
        return ApplicationID;
    }


}