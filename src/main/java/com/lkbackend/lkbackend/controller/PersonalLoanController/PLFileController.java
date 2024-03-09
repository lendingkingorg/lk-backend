package com.lkbackend.lkbackend.controller.PersonalLoanController;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.lkbackend.lkbackend.Entity.DocumentUploadRequest;
import com.lkbackend.lkbackend.Repo.PLDocumentRepository;
import com.lkbackend.lkbackend.model.PLDocumentUploadDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.status;

@RestController
@Slf4j
public class PLFileController {

    @Autowired
    PLDocumentRepository plDocumentRepository;

    @Autowired
    private AmazonS3 s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @PostMapping(value = "/pl-document-upload/{mobNo}", consumes = {"multipart/form-data", "application/json"})
    public ResponseEntity<?> handleFileUpload(
            @RequestPart(value = "file") MultipartFile file,
            @PathVariable long mobNo,
            @RequestPart DocumentUploadRequest documentUploadRequest) {
        try {
            log.info("Received file upload request for mobNo: {}", mobNo);
            System.out.println("Request Headers: " + documentUploadRequest.getDocumentType().toString());
            LocalDateTime localDateTime = LocalDateTime.now();

            String keyName = generateKey(file.getOriginalFilename(), file.getContentType());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.addUserMetadata("mobileNumber", String.valueOf(mobNo));
            s3Client.putObject(new PutObjectRequest(bucketName, keyName, file.getInputStream(), objectMetadata));


            String bankInfo = documentUploadRequest.getDocumentInfo();
            if (!plDocumentRepository.existsById(mobNo)) {
                PLDocumentUploadDetails documentUploadDetails = new PLDocumentUploadDetails();
                documentUploadDetails.setMobileNo(mobNo);
                plDocumentRepository.save(documentUploadDetails);
            }
            System.out.println(documentUploadRequest.getDocumentType().contains("BankStatement"));
            PLDocumentUploadDetails documentInfo = plDocumentRepository.findByMobileNo(mobNo);
            if (documentUploadRequest.getDocumentType().contains("BankStatement")) {


                if (documentInfo.getBankStatementOne() == null) {
                    documentInfo.setBankStatementOne(keyName);
                    documentInfo.setBankInfoOne(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementOneDocFormat(documentUploadRequest.getDocumentFormat());

                } else if (documentInfo.getBankStatementTwo() == null) {
                    documentInfo.setBankStatementTwo(keyName);
                    documentInfo.setBankInfoTwo(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementTwoDocFormat(documentUploadRequest.getDocumentFormat());

                } else if (documentInfo.getBankStatementThree() == null) {
                    documentInfo.setBankStatementThree(keyName);
                    documentInfo.setBankInfoThree(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementThreeDocFormat(documentUploadRequest.getDocumentFormat());

                } else if (documentInfo.getBankStatementFour() == null) {
                    documentInfo.setBankStatementFour(keyName);
                    documentInfo.setBankInfoFour(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementFourDocFormat(documentUploadRequest.getDocumentFormat());

                } else {
                    documentInfo.setBankStatementFive(keyName);
                    documentInfo.setBankInfoFive(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementFiveDocFormat(documentUploadRequest.getDocumentFormat());

                }

            }
            else if(documentUploadRequest.getDocumentType().contains("Pan")){
                documentInfo.setPanCard(keyName);
            }
            else if(documentUploadRequest.getDocumentType().contains("IdProof")){
                documentInfo.setIdProof(keyName);
            }
            else if(documentUploadRequest.getDocumentType().contains("AddressProof")){
                documentInfo.setAddressProof(keyName);
            }


            plDocumentRepository.save(documentInfo);
            log.info("File uploaded successfully for mobNo: {}", mobNo);
            return new ResponseEntity<>(documentInfo, HttpStatus.OK);
        } catch (IOException e) {
            log.error("Error uploading file for mobNo: {}", mobNo, e);
            return new ResponseEntity<>("Error uploading file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateKey(String originalFilename, String contentType) {
        return UUID.randomUUID().toString() + "_" + originalFilename;
    }

    @PostMapping("/pl-file-removal/{mobNo}/{documentID}")
    public ResponseEntity<?> removeFile(@PathVariable Long  mobNo , @PathVariable String documentID){
        log.info("Received request to remove file for mobNo: {}, documentID: {}", mobNo, documentID);

        PLDocumentUploadDetails documentInfo=  plDocumentRepository.findByMobileNo(mobNo);

        // Check if documentInfo is null
        if (documentInfo == null) {
            // Handle the case where the document is not found
            return status(HttpStatus.NOT_FOUND).build();
        }


        switch (documentID) {
            case "bankStatementUrlOne":
                System.out.println("Processing BankStatement_1");
                documentInfo.setBankStatementOne(null);
                documentInfo.setBankInfoOne(null);
                documentInfo.setBankStatementOneDocFormat(null);


                break;
            case "bankStatementUrlTwo":
                // logic for BankStatement_2
                System.out.println("Processing BankStatement_2");
                documentInfo.setBankStatementTwo(null);
                documentInfo.setBankInfoTwo(null);
                documentInfo.setBankStatementTwoDocFormat(null);
                break;
            case "bankStatementUrlThree":
                // logic for BankStatement_3
                System.out.println("Processing BankStatement_3");
                documentInfo.setBankStatementThree(null);
                documentInfo.setBankInfoThree(null);
                documentInfo.setBankStatementThreeDocFormat(null);

                break;
            case "bankStatementUrlFour":
                // logic for BankStatement_4
                System.out.println("Processing BankStatement_4");
                documentInfo.setBankStatementFour(null);
                documentInfo.setBankInfoFour(null);
                documentInfo.setBankStatementFourDocFormat(null);

                break;
            case "bankStatementUrlFive":
                // logic for BankStatement_5
                System.out.println("Processing BankStatement_5");
                documentInfo.setBankStatementFive(null);
                documentInfo.setBankInfoFive(null);
                documentInfo.setBankStatementFiveDocFormat(null);

                break;
            case "Pan":
                // logic for Pan
                System.out.println("Processing Pan");
                documentInfo.setPanCard(null);
                break;
            case "IdProof":
                // logic for Pan
                System.out.println("Processing IdProof");
                documentInfo.setIdProof(null);
                break;
            case "AddressProof":
                // logic for Pan
                System.out.println("Processing AddressProof");
                documentInfo.setAddressProof(null);
                break;
        }

        plDocumentRepository.save(documentInfo);
        log.info("File URL Removed Sucessfully");
        return status(HttpStatus.OK).body("fileUrl Removed Sucessfully");

    }

}
