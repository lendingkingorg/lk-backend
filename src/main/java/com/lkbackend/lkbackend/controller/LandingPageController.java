package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Repo.LPFormRepo;
import com.lkbackend.lkbackend.model.LPFormTbl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LandingPageController {
    @Autowired
    LPFormRepo lpFormRepo;

    @PostMapping("/form-tbl-upload")
    public ResponseEntity<?> LPFormUpload(@RequestBody LPFormTbl lpFormTbl) {
        log.info("Received request to upload LPFormTbl data: {}", lpFormTbl);
        LPFormTbl formData = lpFormRepo.save(lpFormTbl);
        log.info("LPFormTbl data uploaded successfully: {}", formData);
        return new ResponseEntity<>(formData, HttpStatus.OK);
    }

}
