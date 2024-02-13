package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.repo.OnSalaryInfoRepo;
import com.lkbackend.lkbackend.model.OnSalaryInfoTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnSalaryController {
    @Autowired
    OnSalaryInfoRepo onSalaryInfoRepo;

    @PostMapping("/save-onsalary-info/")
    public ResponseEntity<?> LPFormUpload(@RequestBody OnSalaryInfoTbl onSalaryInfoTbl)
    {
          onSalaryInfoRepo.save(onSalaryInfoTbl);
        return new ResponseEntity<>("DATA_SAVED", HttpStatus.OK);
    }

}
