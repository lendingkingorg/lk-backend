package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Repo.ApplicationCentralBinRepo;
import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import com.lkbackend.lkbackend.model.LoanApplicationDetails;
import com.lkbackend.lkbackend.Service.BusinessEngineServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class BusinessEngineController {

    @Autowired
    BusinessEngineServiceInterface businessEngineServiceInterface;

    @Autowired
    ApplicationCentralBinRepo applicationCentralBinRepo;
    @PostMapping("business-engine-api/{mobNo}")
    public ResponseEntity<?> sendDocToLenders(@PathVariable Long mobNo){

        try {

           Long sol= businessEngineServiceInterface.runBusinessEngine(mobNo);
           if(sol==null)return new ResponseEntity<>( "NO_DATA_FOUND", HttpStatus.OK);

            return new ResponseEntity<>( sol, HttpStatus.OK);

        }
        catch (Exception errorMessage){
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("get-application-id/{mobNo}")
    public ResponseEntity<?> getApplicationID(@PathVariable Long mobNo){

        try {
         List<ApplicationCentralBin> allUser= applicationCentralBinRepo.findAllByMobileNo(mobNo);


            ApplicationCentralBin finalElement = null;
         for(ApplicationCentralBin x : allUser){
            if(Objects.equals(mobNo, x.getMobileNo())){
                finalElement=x;
              //  break;
            }


         }
             //    .findAllByMobileNo(mobNo);
           return new ResponseEntity<>( finalElement.getApplicationID(), HttpStatus.OK);

        }
        catch (Exception errorMessage){
            return new ResponseEntity<>("SORRY_SOMETHING_WENT_WRONG", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
