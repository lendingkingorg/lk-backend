package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.Repo.LoanApplicationRepository;
import com.lkbackend.lkbackend.model.OnSalaryInfoTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DashboardController {
@Autowired
    LoanApplicationRepository loanApplicationRepository;
    @Autowired
    LendingInfoRepo lendingInfoRepo;

    @GetMapping("/get-all-user-data/")
    public ResponseEntity<?> getUserData()
    {
Map<String, List<?>> userData=new HashMap<>();
        userData.put("applicationData",loanApplicationRepository.findAll());
        userData.put("userData",lendingInfoRepo.findAll());

       return new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @GetMapping("/admin-login/{passcode}/{userName}")
    public ResponseEntity<?> loginUser(@PathVariable String passcode,@PathVariable String userName)
    {
        if(passcode=="admin!1998@_" && userName=="superAdminLendingKing")return new ResponseEntity<>("L1-ACCESS", HttpStatus.OK);
        if(passcode=="admin!2000@_" && userName=="adminLendingKing")return new ResponseEntity<>("L2-ACCESS", HttpStatus.OK);

        return new ResponseEntity<>("NO_ACCESS", HttpStatus.OK);
    }

}
