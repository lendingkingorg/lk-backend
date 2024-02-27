package com.lkbackend.lkbackend.controller.PersonalLoanController;

import com.lkbackend.lkbackend.Entity.DocumentURL;
import com.lkbackend.lkbackend.Repo.PLApplicationRepository;
import com.lkbackend.lkbackend.Service.LoanApplicationServiceInterface;
import com.lkbackend.lkbackend.model.BLApplicationDetails;
import com.lkbackend.lkbackend.model.BLDocumentUploadDetails;
import com.lkbackend.lkbackend.model.PLApplicationDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/document-api")
@Slf4j
public class PLApplicationController {
    @Autowired
    PLApplicationRepository plApplicationRepository;
    @PostMapping("/pl-save-personal-loan-info/")

    public ResponseEntity<?> saveBusinessDetails(@RequestBody PLApplicationDetails loanApplication){
        try {
            log.info("Received request to save PERSONAL loan application details: {}", loanApplication);
            // Return a success response with a status code of 200 and a custom message
            PLApplicationDetails res= plApplicationRepository.save(loanApplication);
            String message = "Data saved successfully";

            // Create a Map for the JSON response
            Map<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("isSaved", res!=null);
            jsonResponse.put("message", message);
            log.info("Loan application details saved successfully");
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

        }
        catch (Exception e){
            log.error("Failed to save loan application details "+ e.getMessage());
            // Return an error response with a status code of 500 and a custom message
            String errorMessage = "Failed to save data";
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @GetMapping("/pl-loan-application-status/{mobNo}")
//
//    public ResponseEntity<?> uploadStatus(@PathVariable Long mobNo){
//        try {
//            log.info("Received request to fetch loan application status for mobile number: {}", mobNo);
//            BLDocumentUploadDetails res=  loanApplicationServiceInterface.uploadStatus(mobNo);
//            Boolean userDetailsStatus=  loanApplicationServiceInterface.docUploadStatus(mobNo);
//            DocumentURL documentURL=null;
//            if(res!=null) {
//                documentURL=new DocumentURL(res);
//            }
//
//            Map<String, Object> jsonResponse = new HashMap<>();
//            jsonResponse.put("userDetailsStatus", userDetailsStatus);
//            jsonResponse.put("DocumentDetails", documentURL);
//            log.info("Loan application status fetched successfully");
//            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
//
//        }
//        catch (Exception errorMessage){
//            log.error("Failed to fetch loan application status " + errorMessage.getMessage());
//            // Return an error response with a status code of 500 and a custom message
//            //  String errorMessage = "Failed to Fetch Status";
//            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }

}

