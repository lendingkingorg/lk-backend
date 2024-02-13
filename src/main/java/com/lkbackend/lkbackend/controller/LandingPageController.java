package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.repo.LPFormRepo;
import com.lkbackend.lkbackend.model.LPFormTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPageController {
    @Autowired
LPFormRepo lpFormRepo;

    @PostMapping("/form-tbl-upload")
    public ResponseEntity<?> LPFormUpload(@RequestBody LPFormTbl lpFormTbl)
    {

        LPFormTbl formData=   lpFormRepo.save(lpFormTbl);
        return new ResponseEntity<>(formData, HttpStatus.OK);
    }

}
