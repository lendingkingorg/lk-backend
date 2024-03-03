package com.lkbackend.lkbackend.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.lkbackend.lkbackend.Entity.DocumentUploadRequest;
import com.lkbackend.lkbackend.Repo.DocumentRepository;
import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.s3handler.S3Handler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.status;

@RestController
@Slf4j
@RequiredArgsConstructor
public class FileController {

    private final DocumentRepository documentRepository;

    private final AmazonS3 s3Client;

    private final S3Handler s3Handler;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @PostMapping(value = "/bl-document-upload/{mobNo}", consumes = {"multipart/form-data", "application/json"})
    public ResponseEntity<?> handleFileUpload(
            @RequestPart(value = "file") MultipartFile file,
            @PathVariable long mobNo,
            @RequestPart DocumentUploadRequest documentUploadRequest) {
        try {
            log.info("Received file upload request for mobNo: {}", mobNo);
            System.out.println("Request Headers: " + documentUploadRequest.getDocumentType());

            String keyName = generateKey(file.getOriginalFilename(), file.getContentType());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.addUserMetadata("mobileNumber", String.valueOf(mobNo));
            s3Client.putObject(new PutObjectRequest(bucketName, keyName, file.getInputStream(), objectMetadata));

            String bankInfo = documentUploadRequest.getDocumentInfo();
            if (!documentRepository.existsById(mobNo)) {
                DocumentUploadDetails documentUploadDetails = new DocumentUploadDetails();
                documentUploadDetails.setMobileNo(mobNo);
                documentRepository.save(documentUploadDetails);
            }
            System.out.println(documentUploadRequest.getDocumentType().contains("BankStatement"));
            DocumentUploadDetails documentInfo = documentRepository.findByMobileNo(mobNo);
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

            } else if (documentUploadRequest.getDocumentType().contains("Pan")) {
                documentInfo.setPanCard(keyName);
            } else if (documentUploadRequest.getDocumentType().contains("BusinessRegistration")) {
                documentInfo.setBusinessRegistrationProof(keyName);
            } else if (documentUploadRequest.getDocumentType().contains("BusinessAddress")) {
                documentInfo.setBusinessAddressProof(keyName);
            } else if (documentUploadRequest.getDocumentType().contains("IDProofOfGuarantor")) {
                documentInfo.setIdProofOfGuarantor(keyName);
            }

            documentRepository.save(documentInfo);
            log.info("File uploaded successfully for mobNo: {}", mobNo);
            return new ResponseEntity<>(documentInfo, HttpStatus.OK);
        } catch (IOException e) {
            log.error("Error uploading file for mobNo: {}", mobNo, e);
            return new ResponseEntity<>("Error uploading file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateKey(String originalFilename, String contentType) {
        return UUID.randomUUID().toString() + "_" + originalFilename + "."+ Objects
                .requireNonNull(contentType).split("/")[1];
    }

    @PostMapping("/bl-file-removal/{mobNo}/{documentID}")
    public ResponseEntity<?> removeFile(@PathVariable Long mobNo, @PathVariable String documentID) {
        log.info("Received request to remove file for mobNo: {}, documentID: {}", mobNo, documentID);

        DocumentUploadDetails documentInfo = documentRepository.findByMobileNo(mobNo);

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
            case "BusinessRegistration":
                // logic for BusinessRegistration
                System.out.println("Processing BusinessRegistration");
                documentInfo.setBusinessRegistrationProof(null);
                break;
            case "BusinessAddress":
                // logic for BusinessAddress
                System.out.println("Processing BusinessAddress");
                documentInfo.setBusinessAddressProof(null);
                break;
            case "IDProofOfGuarantor":
                // logic for IDProofOfGuarantor
                System.out.println("Processing IDProofOfGuarantor");
                documentInfo.setIdProofOfGuarantor(null);
                break;
        }

        documentRepository.save(documentInfo);
        log.info("File URL Removed Sucessfully");
        return status(HttpStatus.OK).body("fileUrl Removed Sucessfully");

    }

    @GetMapping("/getFileUrl/{keyName}")
    public ResponseEntity<URL> getUserData(@PathVariable final String keyName) {
        return new ResponseEntity<>(s3Handler.getPresignedUrl(keyName), HttpStatus.OK);
    }

}
