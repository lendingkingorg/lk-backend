package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.ReferralExists;
import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@Slf4j
public class ReferralCodeController {

    private final LendingInfoService lendingInfoService;

    @Autowired
    private LendingInfoRepo lendingInfoRepo;

    public ReferralCodeController(LendingInfoService lendingInfoService) {
        this.lendingInfoService = lendingInfoService;
    }

    @GetMapping("/check-referral")
    public ReferralExists ReferralCode(@RequestParam String referral) {
        log.info("Checking referral code: {}", referral);
        LendingInfo referral_info = lendingInfoService.findByReferral(referral);
        ReferralExists referralExists = new ReferralExists();
        ReferralExists.Data data = new ReferralExists.Data();
        referralExists.setData(data);

        if (referral_info != null) {
            data.setReferralExists(true);
            referralExists.setMessage("Referral Found");
            referralExists.setStatusCode(200);
            referralExists.setUserId(String.valueOf(referral_info.getMobileNumber()));
            log.info("Referral code found for user with mobile number: {}", referral_info.getMobileNumber());
            return referralExists;
        } else {
            data.setReferralExists(false);
            referralExists.setMessage("Referral Not found");
            log.info("Referral code not found for referral: {}", referral);
            return referralExists;
        }

    }

    @GetMapping("/get-referral/{mobNo}")
    public ResponseEntity<?> getCode(@PathVariable long mobNo) {
        log.info("Fetching referral code for user with mobile number: {}", mobNo);
        LendingInfo user = lendingInfoRepo.findByMobileNumber(mobNo);
        Map<String, Object> response = new HashMap<>();
        if (user == null) {
            // Handle the case where the user is not found
            response.put("referral", null);
            log.error("User with mobile number {} not found", mobNo);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("referral", user.getReferral());
        log.info("Referral code fetched successfully for user with mobile number: {}", mobNo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
