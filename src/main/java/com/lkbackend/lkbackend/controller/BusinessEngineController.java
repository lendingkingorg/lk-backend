package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.repo.ApplicationCentralBinRepo;
import com.lkbackend.lkbackend.service.BusinessEngineServiceInterface;
import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

            HashMap<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("ApplicationID",sol );


            return new ResponseEntity<>( jsonResponse, HttpStatus.OK);

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

            }
         }
            HashMap<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("ApplicationID",finalElement.getApplicationID() );
            jsonResponse.put("created_at",finalElement.getCreatedAt() );
             //    .findAllByMobileNo(mobNo);
           return new ResponseEntity<>( jsonResponse, HttpStatus.OK);

        }
        catch (Exception errorMessage){
            return new ResponseEntity<>("SORRY_SOMETHING_WENT_WRONG", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
