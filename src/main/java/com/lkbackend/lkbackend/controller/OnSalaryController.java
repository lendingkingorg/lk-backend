package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Repo.LPFormRepo;
import com.lkbackend.lkbackend.Repo.OnSalaryInfoRepo;
import com.lkbackend.lkbackend.model.LPFormTbl;
import com.lkbackend.lkbackend.model.OnSalaryInfoTbl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OnSalaryController {
    @Autowired
    OnSalaryInfoRepo onSalaryInfoRepo;

    @PostMapping("/save-onsalary-info/")
    public ResponseEntity<?> LPFormUpload(@RequestBody OnSalaryInfoTbl onSalaryInfoTbl) {
        log.info("Received request to save OnSalaryInfo: {}", onSalaryInfoTbl);
        onSalaryInfoRepo.save(onSalaryInfoTbl);
        log.info("OnSalaryInfo saved successfully");
        return new ResponseEntity<>("DATA_SAVED", HttpStatus.OK);
    }

}
