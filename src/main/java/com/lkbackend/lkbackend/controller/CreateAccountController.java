package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.CustomerResponseAccountCreate;
import com.lkbackend.lkbackend.Entity.GenerateReferralCode;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CreateAccountController {

    private final LendingInfoService lendingInfoService;
    @Value("${msg91.send-email-url}")
    private String msg91ApiUrl;

    @Value("${msg91.authkey}")
    String authKey;

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
        lendingInfo.setLk_TnC("True");
        lendingInfo.setCibil_TnC("True");


        lendingInfoService.save(lendingInfo);

        LendingInfo user_info = lendingInfoService.findByMobileNumber(mobile);


        // Create JSON body as a string
        String json = "{\n" +
                "  \"recipients\": [\n" +
                "    {\n" +
                "      \"to\": [\n" +
                "        {\n" +
                "          \"email\": \""+ user_info .getEmail()+ "\",\n" +
                "          \"name\": \""+user_info.getName()+ "\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"from\": {\n" +
                "    \"email\": \"no-reply@mail.lendingking.in\"\n" +
                "  },\n" +
                "  \"domain\": \"mail.lendingking.in\",\n" +
                "  \"template_id\": \"welcome_template_2\"\n" +
                "}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("authkey", authKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String mob = Long.toString(mobile);


        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                msg91ApiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

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
