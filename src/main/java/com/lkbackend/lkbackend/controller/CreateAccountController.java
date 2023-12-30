package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.CustomerResponseAccountCreate;
import com.lkbackend.lkbackend.Entity.GenerateReferralCode;
import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.http.HttpStatus;
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
    public CustomerResponseAccountCreate createAccount(@RequestParam String name, @RequestParam long mobile, @RequestParam int mpin, @RequestParam String email, @RequestParam String pan){
        GenerateReferralCode generateReferralCode = new GenerateReferralCode();
        LendingInfo lendingInfo = new LendingInfo();
        lendingInfo.setMobileNumber(mobile);
        lendingInfo.setmPin(mpin);
        lendingInfo.setEmail(email);
        lendingInfo.setPan(pan);
        lendingInfo.setReferral(generateReferralCode.generateReferralCode());
        lendingInfo.setName(name);


        lendingInfoService.save(lendingInfo);

        CustomerResponseAccountCreate customerResponseAccountCreate = new CustomerResponseAccountCreate();
        CustomerResponseAccountCreate.Data data = new CustomerResponseAccountCreate.Data();
        customerResponseAccountCreate.setData(data);
        data.setAccountCreated(true);
        customerResponseAccountCreate.setMessage("Account Successfully Created");
        customerResponseAccountCreate.setStatusCode(200);
        customerResponseAccountCreate.setUserId(mobile);


        return customerResponseAccountCreate;




    }


}
