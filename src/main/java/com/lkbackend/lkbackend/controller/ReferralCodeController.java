package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ReferralCodeController {

    private final LendingInfoService lendingInfoService;

    public ReferralCodeController(LendingInfoService lendingInfoService) {
        this.lendingInfoService = lendingInfoService;
    }

    @GetMapping("/get-referral")
    public boolean ReferralCode(@RequestParam String referral){
        LendingInfo referral_info = lendingInfoService.findByReferral(referral);
        if (referral_info != null){
            return true;
        }else{return false;}

    }



}
