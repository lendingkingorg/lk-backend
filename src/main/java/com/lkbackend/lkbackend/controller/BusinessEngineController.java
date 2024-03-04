package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.ApplicationCentralBinDTO;
import com.lkbackend.lkbackend.Repo.ApplicationCentralBinRepo;
import com.lkbackend.lkbackend.Service.BusinessEngineServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class BusinessEngineController {

    @Autowired
    BusinessEngineServiceInterface businessEngineServiceInterface;

    @Autowired
    ApplicationCentralBinRepo applicationCentralBinRepo;

    @PostMapping("business-engine-api/{mobNo}/{applicationType}")
    public ResponseEntity<?> sendDocToLenders(@PathVariable Long mobNo,@PathVariable String applicationType) {
        log.info("Send Doc To Lenders Started.");
        try {

           ApplicationCentralBinDTO sol= businessEngineServiceInterface.runBusinessEngine(mobNo,applicationType);
           if(sol==null){
               log.info("No data found for mobNo: {}", mobNo);
               return new ResponseEntity<>( "NO_DATA_FOUND", HttpStatus.OK);
           }
            log.info("Send Doc To Lenders Successful for mobNo: {}", mobNo);
            return new ResponseEntity<>( sol, HttpStatus.OK);

        }
        catch (Exception errorMessage){
            log.error("Error while Sending Doc To Lenders for mobNo: {}", mobNo, errorMessage);
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
