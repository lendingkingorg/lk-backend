package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.ApplicationCentralBinDTO;
import com.lkbackend.lkbackend.Service.ApplicationCentralBinServiceInterface;
import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ApplicationCentralBinController {
@Autowired
    ApplicationCentralBinServiceInterface applicationCentralBinServiceInterface;
    @GetMapping("get-user-applications/{mobNo}")
   List<ApplicationCentralBin> getApplicationIDByMobileNumber(@PathVariable Long mobNo){

   return applicationCentralBinServiceInterface.getApplicationIDByMobileNo(mobNo);

   }


    @GetMapping("get-application-id/{mobNo}")
    public ResponseEntity<?> getApplicationID(@PathVariable Long mobNo){

        try {
            ApplicationCentralBin user= applicationCentralBinServiceInterface.findFirstByMobileNoOrderByCreatedAtDesc(mobNo);
            ApplicationCentralBinDTO applicationCentralBinDTO= new ApplicationCentralBinDTO(user.getApplicationID(), user.getRequestedLoanAmount(), user.getCreatedAt());
            return new ResponseEntity<>( applicationCentralBinDTO, HttpStatus.OK);

        }
        catch (Exception errorMessage){
            return new ResponseEntity<>("SORRY_SOMETHING_WENT_WRONG", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
