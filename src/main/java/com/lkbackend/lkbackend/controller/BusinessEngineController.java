package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.ApplicationCentralBinDTO;
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

           ApplicationCentralBinDTO sol= businessEngineServiceInterface.runBusinessEngine(mobNo);
           if(sol==null){
               return new ResponseEntity<>( "NO_DATA_FOUND", HttpStatus.OK);
           }

            return new ResponseEntity<>( sol, HttpStatus.OK);

        }
        catch (Exception errorMessage){
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
