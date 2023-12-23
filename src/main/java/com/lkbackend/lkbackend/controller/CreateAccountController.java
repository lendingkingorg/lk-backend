package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CreateAccountController {

    private final LendingInfoService lendingInfoService;

    public CreateAccountController(LendingInfoService lendingInfoService) {
        this.lendingInfoService = lendingInfoService;
    }

    @PostMapping("/create-account")
    public void createAccount(@RequestParam String name,@RequestParam long mobile, @RequestParam int mpin, @RequestParam String email, @RequestParam String pan, @RequestParam String referral){
        LendingInfo lendingInfo = new LendingInfo();
        lendingInfo.setMobileNumber(mobile);
        lendingInfo.setmPin(mpin);
        lendingInfo.setEmail(email);
        lendingInfo.setPan(pan);
        lendingInfo.setReferral(referral);
        lendingInfo.setName(name);


        lendingInfoService.save(lendingInfo);




    }


}