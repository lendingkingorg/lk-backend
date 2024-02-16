package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.CustomResponseOTPVerify;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
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
@Slf4j
public class VerifyOTPController {

    private static final String MSG91_API_URL_v = "https://control.msg91.com/api/v5/otp/verify";

    private final LendingInfoService lendingInfoService;

    public VerifyOTPController(LendingInfoService lendingInfoService) {
        this.lendingInfoService = lendingInfoService;
    }

    @GetMapping("/verify-otp")
    public CustomResponseOTPVerify verifyOTP(@RequestParam long mobile, @RequestParam int otp) {
        log.info("Verifying OTP for mobile number: {}", mobile);
        LendingInfo user_info = lendingInfoService.findByMobileNumber(mobile);

        CustomResponseOTPVerify customResponseOTPVerify = new CustomResponseOTPVerify();
        CustomResponseOTPVerify.Data data = new CustomResponseOTPVerify.Data();
        CustomResponseOTPVerify.Info info = new CustomResponseOTPVerify.Info();

        customResponseOTPVerify.setData(data);
        data.setInfo(info);


        String authKey = "410480ArZD05k4xV6566f67eP1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("authkey", authKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String mob = Long.toString(mobile);

        String requestBody = "";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                MSG91_API_URL_v + "?mobile=" + mob + "&" + "otp=" + otp,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        if ((responseEntity.getStatusCode() == HttpStatus.OK && (responseEntity.getBody().contains("OTP not match") != true))) {
            data.setOtpVerified(true);
            UUID uuid = java.util.UUID.randomUUID();
            data.setSessionId(uuid);
            if (user_info != null) {
                info.setCustomerExists(true);
                ;
                info.setUserName((user_info.getName()));
                info.setMpin(user_info.getmPin());
                data.setEmail(user_info.getEmail());
                customResponseOTPVerify.setStatusCode(200);
                customResponseOTPVerify.setUserId(mobile);
                customResponseOTPVerify.setMessage("OTP Verified Successfully");
                log.info("OTP verified successfully for mobile number: {}", mobile);
            } else {
                info.setCustomerExists(false);
                info.setMpin(0);
                customResponseOTPVerify.setStatusCode(200);
                customResponseOTPVerify.setUserId(mobile);
                customResponseOTPVerify.setMessage("OTP Verified Successfully");
                log.info("OTP verified successfully for mobile number: {} (No user info found)", mobile);
            }
        } else {
            data.setOtpVerified(false);
            customResponseOTPVerify.setStatusCode(400);
            info.setCustomerExists(false);
            info.setMpin(0);
            customResponseOTPVerify.setUserId(mobile);
            customResponseOTPVerify.setMessage("OTP Verification unsucccessfull");
            log.error("OTP verification unsuccessful for mobile number: {}", mobile);
        }

        return customResponseOTPVerify;


    }
}
