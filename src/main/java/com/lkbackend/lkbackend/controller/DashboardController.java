package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.UserDetailsDTO;
import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.Repo.LoanApplicationRepository;
import com.lkbackend.lkbackend.mapper.UserDetailsMapper;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class DashboardController {

    private final LoanApplicationRepository loanApplicationRepository;

    private final LendingInfoRepo lendingInfoRepo;
    private final UserDetailsMapper userDetailsMapper;



    @GetMapping("/get-all-user/")
    public ResponseEntity<List<UserDetailsDTO>> getUserData() {
        log.info("Request received to fetch all user data.");
        List<UserDetailsDTO> userData = loanApplicationRepository.findAll().stream().map(loanApplicationDetails ->
                userDetailsMapper.mapUserDetailsToDTO(loanApplicationDetails, lendingInfoRepo.findByMobileNumber(loanApplicationDetails.getMobileNo()))).toList();
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @GetMapping("/admin-login/{passcode}/{userName}")
    public ResponseEntity<?> loginUser(@PathVariable String passcode, @PathVariable String userName) {
        log.info("Login attempt for user: {}", userName);

        Map<String, String> access=new HashMap<>();

            if(passcode.equals("admin!1998@_") && userName.equals("superAdminLendingKing"))
            {
                access.put("token","L1-ACCESS");
                return new ResponseEntity<>(access, HttpStatus.OK);}
            if(passcode.equals("admin!2000@_") && userName.equals("adminLendingKing"))
            {
                access.put("token","L2-ACCESS");
                return new ResponseEntity<>(access, HttpStatus.OK);}

            access.put("token",null);
            return new ResponseEntity<>(access, HttpStatus.OK);
    }
}