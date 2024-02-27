package com.lkbackend.lkbackend.Service;


import com.lkbackend.lkbackend.Entity.ApplicationCentralBinDTO;
import com.lkbackend.lkbackend.Repo.*;
import com.lkbackend.lkbackend.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;

import java.util.Optional;

@Service
@Slf4j
public class BusinessEngineServiceImpl implements BusinessEngineServiceInterface{
    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;
    @Autowired
    BLDocumentRepository blDocumentRepository;

    @Autowired
    PLDocumentRepository plDocumentRepository;
    @Autowired
    BLApplicationRepository blApplicationRepository;

    @Autowired
    PLApplicationRepository plApplicationRepository;
    @Autowired
    ApplicationCentralBinRepo applicationCentralBinRepo;
    @Override
    public void getPayLoad(Long mobNo) {
        BLDocumentUploadDetails urlDetails= blDocumentRepository.findByMobileNo(mobNo);
        log.info("Retrieved document upload details for mobile number: {}", mobNo);
    }

    private ApplicationCentralBinDTO saveIntoCentralBin(Long mobNo,String applicationType) {
        try {
            ApplicationCentralBin res =null;
            if (applicationType.equals("BLApplication")) {
                Optional<BLDocumentUploadDetails> urlDetailsOpt = Optional.ofNullable(blDocumentRepository.findByMobileNo(mobNo));
                Optional<BLApplicationDetails> applicantDetailsOpt = Optional.ofNullable(blApplicationRepository.findByMobileNo(mobNo));

                if (urlDetailsOpt.isEmpty() && applicantDetailsOpt.isEmpty()) {
                    log.warn("No document upload details and loan application details found for mobile number: {}", mobNo);
                    // Log or handle the case where both are empty, if needed
                    return null;
                }

                ApplicationCentralBin application = new ApplicationCentralBin(
                        urlDetailsOpt.orElse(null),
                        applicantDetailsOpt.orElse(null),
                        mobNo,
                        applicationType
                );

                 res = applicationCentralBinRepo.save(application);
            } else if (applicationType.equals("PLApplication")) {
                Optional<PLDocumentUploadDetails> urlDetailsOpt = Optional.ofNullable(plDocumentRepository.findByMobileNo(mobNo));
                Optional<PLApplicationDetails> applicantDetailsOpt = Optional.ofNullable(plApplicationRepository.findByMobileNo(mobNo));

                if (urlDetailsOpt.isEmpty() && applicantDetailsOpt.isEmpty()) {
                    log.warn("No document upload details and loan application details found for mobile number: {}", mobNo);
                    // Log or handle the case where both are empty, if needed
                    return null;
                }

                ApplicationCentralBin application = new ApplicationCentralBin(
                        urlDetailsOpt.orElse(null),
                        applicantDetailsOpt.orElse(null),
                        mobNo,
                        applicationType
                );

//                res = applicationCentralBinRepo.save(application);


            }
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
    public ApplicationCentralBinDTO runBusinessEngine(Long mobNo, String applicationType) {
        log.info("Business engine executed successfully for mobile number: {}", mobNo);
        return saveIntoCentralBin(mobNo,applicationType);
    }


}
