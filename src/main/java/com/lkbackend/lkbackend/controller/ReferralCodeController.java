package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.ReferralExists;
import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ReferralCodeController {

    private final LendingInfoService lendingInfoService;

    @Autowired
    private LendingInfoRepo lendingInfoRepo;

    public ReferralCodeController(LendingInfoService lendingInfoService) {
        this.lendingInfoService = lendingInfoService;
    }

    @GetMapping("/check-referral")
    public ReferralExists ReferralCode(@RequestParam String referral){
        LendingInfo referral_info = lendingInfoService.findByReferral(referral);
        ReferralExists referralExists = new ReferralExists();
        ReferralExists.Data data = new ReferralExists.Data();
        referralExists.setData(data);

        if (referral_info != null){
            data.setReferralExists(true);
            referralExists.setMessage("Referral Found");
            referralExists.setStatusCode(200);
            referralExists.setUserId(String.valueOf(referral_info.getMobileNumber()));

            return referralExists;
        }else{
            data.setReferralExists(false);
            referralExists.setMessage("Referral Not found");
            return referralExists;
        }

    }

    @GetMapping("/get-referral/{mobNo}")
    public ResponseEntity<String> getCode(@PathVariable long mobNo) {
        LendingInfo user = lendingInfoRepo.findByMobileNumber(mobNo);

        if (user == null) {
            // Handle the case where the user is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        if (user.getReferral() == null) {
            // Handle the case where the referral is null
            return ResponseEntity.ok("null");
        }

        return ResponseEntity.ok(user.getReferral());
    }



}
