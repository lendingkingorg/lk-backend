package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.DocumentUploadRequest;
import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import com.lkbackend.lkbackend.Repo.DocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.*;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@Slf4j
public class FileController {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @PostMapping(value = "/bl-document-upload/{mobNo}", consumes = {"multipart/form-data", "application/json"})
    public ResponseEntity<?> handleFileUpload(
            @RequestPart(value = "file") MultipartFile file,
            @PathVariable long mobNo,
            @RequestPart DocumentUploadRequest documentUploadRequest) {
        try {
            log.info("Received file upload request for mobNo: {}", mobNo);
            System.out.println("Request Headers: " + documentUploadRequest.getDocumentType().toString());
            LocalDateTime localDateTime = LocalDateTime.now();

            String key = generateKey(file.getOriginalFilename());
            File modifiedFile = new File(file.getOriginalFilename());
            FileOutputStream os = new FileOutputStream(modifiedFile);
            os.write(file.getBytes());
            String fileUrl = "https://" + bucketName + ".s3.amazonaws.com/" + key + '/' + localDateTime.toString();

            s3Client.putObject(PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build(), RequestBody.fromFile(modifiedFile));

            String bankInfo = documentUploadRequest.getDocumentInfo();
            if (!documentRepository.existsById(mobNo)) {
                DocumentUploadDetails documentUploadDetails = new DocumentUploadDetails();
                documentUploadDetails.setMobileNo(mobNo);
                documentRepository.save(documentUploadDetails);
            }
            System.out.println(documentUploadRequest.getDocumentType().contains("BankStatement"));
            DocumentUploadDetails documentInfo = documentRepository.findByMobileNo(mobNo);
            if (documentUploadRequest.getDocumentType().contains("BankStatement")) {


                if (documentInfo.getBankStatementUrlOne() == null) {
                    documentInfo.setBankStatementUrlOne(fileUrl);
                    documentInfo.setBankInfoOne(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementOneDocFormat(documentUploadRequest.getDocumentFormat());

                } else if (documentInfo.getBankStatementUrlTwo() == null) {
                    documentInfo.setBankStatementUrlTwo(fileUrl);
                    documentInfo.setBankInfoTwo(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementTwoDocFormat(documentUploadRequest.getDocumentFormat());

                } else if (documentInfo.getBankStatementUrlThree() == null) {
                    documentInfo.setBankStatementUrlThree(fileUrl);
                    documentInfo.setBankInfoThree(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementThreeDocFormat(documentUploadRequest.getDocumentFormat());

                } else if (documentInfo.getBankStatementUrlFour() == null) {
                    documentInfo.setBankStatementUrlFour(fileUrl);
                    documentInfo.setBankInfoFour(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementFourDocFormat(documentUploadRequest.getDocumentFormat());

                } else {
                    documentInfo.setBankStatementUrlFive(fileUrl);
                    documentInfo.setBankInfoFive(documentUploadRequest.getDocumentInfo());
                    documentInfo.setBankStatementFiveDocFormat(documentUploadRequest.getDocumentFormat());

                }

            }
            else if(documentUploadRequest.getDocumentType().contains("Pan")){
                documentInfo.setPanCardUrl(fileUrl);
            }
            else if(documentUploadRequest.getDocumentType().contains("BusinessRegistration")){
                documentInfo.setBusinessRegistrationProofUrl(fileUrl);
            }
            else if(documentUploadRequest.getDocumentType().contains("BusinessAddress")){
                documentInfo.setBusinessAddressProofUrl(fileUrl);
            }
            else if(documentUploadRequest.getDocumentType().contains("IDProofOfGuarantor")){
                documentInfo.setIdProofOfGuarantorUrl(fileUrl);
            }

            documentRepository.save(documentInfo);
            modifiedFile.delete();
            log.info("File uploaded successfully for mobNo: {}", mobNo);
            return new ResponseEntity<>(documentInfo, HttpStatus.OK);
        } catch (IOException e) {
            log.error("Error uploading file for mobNo: {}", mobNo, e);
            return new ResponseEntity<>("Error uploading file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateKey(String originalFilename) {
        return UUID.randomUUID().toString() + "_" + originalFilename;
    }

    @PostMapping("/bl-file-removal/{mobNo}/{documentID}")
    public ResponseEntity<?> removeFile(@PathVariable Long  mobNo , @PathVariable String documentID){
        log.info("Received request to remove file for mobNo: {}, documentID: {}", mobNo, documentID);

        DocumentUploadDetails documentInfo=  documentRepository.findByMobileNo(mobNo);

        // Check if documentInfo is null
        if (documentInfo == null) {
            // Handle the case where the document is not found
            return status(HttpStatus.NOT_FOUND).build();
        }


        switch (documentID) {
            case "bankStatementUrlOne":
                System.out.println("Processing BankStatement_1");
                documentInfo.setBankStatementUrlOne(null);
                documentInfo.setBankInfoOne(null);
                documentInfo.setBankStatementOneDocFormat(null);


                break;
            case "bankStatementUrlTwo":
                // logic for BankStatement_2
                System.out.println("Processing BankStatement_2");
                documentInfo.setBankStatementUrlTwo(null);
                documentInfo.setBankInfoTwo(null);
                documentInfo.setBankStatementTwoDocFormat(null);
                break;
            case "bankStatementUrlThree":
                // logic for BankStatement_3
                System.out.println("Processing BankStatement_3");
                documentInfo.setBankStatementUrlThree(null);
                documentInfo.setBankInfoThree(null);
                documentInfo.setBankStatementThreeDocFormat(null);

                break;
            case "bankStatementUrlFour":
                // logic for BankStatement_4
                System.out.println("Processing BankStatement_4");
                documentInfo.setBankStatementUrlFour(null);
                documentInfo.setBankInfoFour(null);
                documentInfo.setBankStatementFourDocFormat(null);

                break;
            case "bankStatementUrlFive":
                // logic for BankStatement_5
                System.out.println("Processing BankStatement_5");
                documentInfo.setBankStatementUrlFive(null);
                documentInfo.setBankInfoFive(null);
                documentInfo.setBankStatementFiveDocFormat(null);

                break;
            case "Pan":
                // logic for Pan
                System.out.println("Processing Pan");
                documentInfo.setPanCardUrl(null);
                break;
            case "BusinessRegistration":
                // logic for BusinessRegistration
                System.out.println("Processing BusinessRegistration");
                documentInfo.setBusinessRegistrationProofUrl(null);
                break;
            case "BusinessAddress":
                // logic for BusinessAddress
                System.out.println("Processing BusinessAddress");
                documentInfo.setBusinessAddressProofUrl(null);
                break;
            case "IDProofOfGuarantor":
                // logic for IDProofOfGuarantor
                System.out.println("Processing IDProofOfGuarantor");
                documentInfo.setIdProofOfGuarantorUrl(null);
                break;
        }

        documentRepository.save(documentInfo);
        log.info("File URL Removed Sucessfully");
        return status(HttpStatus.OK).body("fileUrl Removed Sucessfully");

    }

}
