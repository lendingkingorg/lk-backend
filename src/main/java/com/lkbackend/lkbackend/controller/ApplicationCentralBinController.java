package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Service.ApplicationCentralBinServiceInterface;
import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import org.springframework.beans.factory.annotation.Autowired;
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

}
