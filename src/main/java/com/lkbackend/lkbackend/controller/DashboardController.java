package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.Repo.LoanApplicationRepository;
import com.lkbackend.lkbackend.model.OnSalaryInfoTbl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class DashboardController {
@Autowired
    LoanApplicationRepository loanApplicationRepository;
    @Autowired
    LendingInfoRepo lendingInfoRepo;

    @GetMapping("/get-all-user-data/")
    public ResponseEntity<?> getUserData()
    {
        log.info("Request received to fetch all user data.");
        Map<String, List<?>> userData=new HashMap<>();
        userData.put("applicationData",loanApplicationRepository.findAll());
        userData.put("userData",lendingInfoRepo.findAll());
        log.info("Returning all user data.");
       return new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @GetMapping("/admin-login/{passcode}/{userName}")
    public ResponseEntity<?> loginUser(@PathVariable String passcode, @PathVariable String userName) {
        log.info("Login attempt for user: {}", userName);

        if ("admin!1998@_".equals(passcode) && "superAdminLendingKing".equals(userName)) {
            log.info("Successful login for super admin.");
            return new ResponseEntity<>("L1-ACCESS", HttpStatus.OK);
        } else if ("admin!2000@_".equals(passcode) && "adminLendingKing".equals(userName)) {
            log.info("Successful login for admin.");
            return new ResponseEntity<>("L2-ACCESS", HttpStatus.OK);
        } else {
            log.warn("Failed login attempt for user: {}", userName);
            return new ResponseEntity<>("NO_ACCESS", HttpStatus.OK);
        }
    }
}