package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.CustomResponseOTPSent;
import com.lkbackend.lkbackend.Entity.CustomResponseOTPVerify;
import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class VerifyOTPController {

    private static final String MSG91_API_URL_v = "https://control.msg91.com/api/v5/otp/verify";

    LendingInfoRepo repo ;

    @GetMapping("/verify-otp")
    public CustomResponseOTPVerify verifyOTP(@RequestParam long mobile, @RequestParam int otp) {

        CustomResponseOTPVerify customResponseOTPVerify = new CustomResponseOTPVerify();
        CustomResponseOTPVerify.Data  data = new CustomResponseOTPVerify.Data();
        CustomResponseOTPVerify.Info info = new CustomResponseOTPVerify.Info();

        data.setInfo(info);

        String authKey = "410480ArZD05k4xV6566f67eP1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("authkey", authKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                MSG91_API_URL_v + "?mobile=" + mobile + "&" + "otp=" + otp,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            data.setOtpVerified(true);
            if(repo.findByFieldName(mobile)!= null){
                info.setCustomerExists(true);

                info.setMpin(repo.findByFieldName(mpin);

            }
            customResponseOTPVerify.setStatusCode(200);
            customResponseOTPVerify.setUserId(mobile);
            customResponseOTPVerify.setMessage("MessageSuccessfully sent");


        } else {
            data.setOtpVerified(false);
            customResponseOTPVerify.setStatusCode(400);
            info.setCustomerExists(false);
            info.setMpin(0);
            customResponseOTPVerify.setUserId(mobile);
            customResponseOTPVerify.setMessage("Message unsuccessfull");
        }

        return customResponseOTPVerify;


    }
}
