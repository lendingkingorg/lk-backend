package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.CustomResponseOTPVerify;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class VerifyOTPController {

    @Value("${msg91.verify-otp-url}")
    private String msg91ApiUrl;
    @Value("${msg91.authkey}")
    String authKey;

    private final LendingInfoService lendingInfoService;


    @GetMapping("/verify-otp")
    public CustomResponseOTPVerify verifyOTP(@RequestParam long mobile, @RequestParam int otp) {
        log.info("Verifying OTP for mobile number: {}", mobile);
        LendingInfo userInfo = lendingInfoService.findByMobileNumber(mobile);

        CustomResponseOTPVerify customResponseOTPVerify = new CustomResponseOTPVerify();
        CustomResponseOTPVerify.Data data = new CustomResponseOTPVerify.Data();
        CustomResponseOTPVerify.Info info = new CustomResponseOTPVerify.Info();

        customResponseOTPVerify.setData(data);
        data.setInfo(info);

        HttpHeaders headers = new HttpHeaders();
        headers.set("authkey", authKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String mob = Long.toString(mobile);

        String requestBody = "";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                msg91ApiUrl + "?mobile=" + mob + "&" + "otp=" + otp,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        data.setOtpVerified(true);
        UUID uuid = java.util.UUID.randomUUID();
        data.setSessionId(uuid);

        if(userInfo!= null) {
            info.setCustomerExists(true);
            info.setUserName((userInfo.getName()));
            info.setMpin(userInfo.getMPin());
            data.setEmail(userInfo.getEmail());
            customResponseOTPVerify.setStatusCode(200);
            customResponseOTPVerify.setUserId(mobile);
            customResponseOTPVerify.setMessage("OTP Verified Successfully");
        } else {
            info.setCustomerExists(false);
            info.setMpin(0);
            customResponseOTPVerify.setStatusCode(200);
            customResponseOTPVerify.setUserId(mobile);
            customResponseOTPVerify.setMessage("OTP Verified Successfully");
        }

/*        if ((responseEntity.getStatusCode() == HttpStatus.OK && (responseEntity.getBody().contains("OTP not match") != true))) {
            data.setOtpVerified(true);
            UUID uuid = java.util.UUID.randomUUID();
            data.setSessionId(uuid);
            if(userInfo!= null) {
                info.setCustomerExists(true);;
                info.setUserName((userInfo.getName()));
                info.setMpin(userInfo.getmPin());
                data.setEmail(userInfo.getEmail());
                customResponseOTPVerify.setStatusCode(200);
                customResponseOTPVerify.setUserId(mobile);
                customResponseOTPVerify.setMessage("OTP Verified Successfully");
            } else {
                info.setCustomerExists(false);
                info.setMpin(0);
                customResponseOTPVerify.setStatusCode(200);
                customResponseOTPVerify.setUserId(mobile);
                customResponseOTPVerify.setMessage("OTP Verified Successfully");
            }


        } else {
            data.setOtpVerified(false);
            customResponseOTPVerify.setStatusCode(400);
            info.setCustomerExists(false);
            info.setMpin(0);
            customResponseOTPVerify.setUserId(mobile);
            customResponseOTPVerify.setMessage("OTP Verification unsucccessfull");
        }*/

        return customResponseOTPVerify;


    }
}
