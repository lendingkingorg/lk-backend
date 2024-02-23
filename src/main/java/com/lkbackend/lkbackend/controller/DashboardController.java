package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.Repo.LoanApplicationRepository;
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
    public ResponseEntity<?> getUserData() {
        log.info("Request received to fetch all user data.");
        Map<String, List<?>> userData = new HashMap<>();
        userData.put("applicationData", loanApplicationRepository.findAll());
        userData.put("userData", lendingInfoRepo.findAll());
        log.info("Returning all user data.");
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @GetMapping("/admin-login/{passcode}/{userName}")
    public ResponseEntity<?> loginUser(@PathVariable String passcode, @PathVariable String userName) {
        log.info("Login attempt for user: {}", userName);

        Map<String, String> access=new HashMap<>();

            if(passcode=="admin!1998@_" && userName=="superAdminLendingKing")
            {
                access.put("token","L1-ACCESS");
                return new ResponseEntity<>(access, HttpStatus.OK);}
            if(passcode=="admin!2000@_" && userName=="adminLendingKing")
            {
                access.put("token","L2-ACCESS");
                return new ResponseEntity<>(access, HttpStatus.OK);}

            access.put("token","NO_ACCESS");
            return new ResponseEntity<>(access, HttpStatus.OK);
    }
}