package com.lkbackend.lkbackend.Service;


import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.Repo.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class BusinessEngineServiceImpl implements BusinessEngineServiceInterface{


    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;
    @Autowired
    DocumentRepository documentRepository;
    @Override
    public void getPayLoad(Long mobNo) {

        DocumentUploadDetails urlDetails= documentRepository.findByMobileNo(mobNo);



    }

    @Override
    public void runBusinessEngine(Long mobNo) {

    }


}
