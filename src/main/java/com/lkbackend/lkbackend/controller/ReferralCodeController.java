package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.ReferralExists;
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



}
