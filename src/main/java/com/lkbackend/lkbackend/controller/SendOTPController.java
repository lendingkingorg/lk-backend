package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.CustomResponseOTPSent;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@Slf4j
public class SendOTPController {

    @Value("${msg91.send-otp-url}")
    private String msg91ApiUrl;
    @Value("${msg91.authkey}")
    String authKey;

    @PostMapping("/send-otp")
    public CustomResponseOTPSent sendOTP(@RequestParam String mobile) {
        log.info("Sending OTP for mobile number: {}", mobile);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authkey",authKey);
        headers.set("6566f66ad6fc05476e020572", "template_id");

        String requestBody = "";

        CustomResponseOTPSent customResponseOTPSent = new CustomResponseOTPSent();
        CustomResponseOTPSent.Data data = new CustomResponseOTPSent.Data();

        customResponseOTPSent.setData(data);

        if (mobile.length() == 12) {

            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    msg91ApiUrl + "?mobile=" + mobile + "&template_id=6566f66ad6fc05476e020572",
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );


            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                data.setOtp_sent(true);
                customResponseOTPSent.setStatusCode(200);
                customResponseOTPSent.setUserId(mobile);
                customResponseOTPSent.setMessage("OTP Sent Successfully");
                log.info("OTP sent successfully to mobile number: {}", mobile);

            } else {
                data.setOtp_sent(false);
                customResponseOTPSent.setStatusCode(400);
                customResponseOTPSent.setUserId(mobile);
                customResponseOTPSent.setMessage("OTP Unsuccessfull");
                log.error("Failed to send OTP to mobile number: {}", mobile);
            }
        } else {
            data.setOtp_sent(false);
            customResponseOTPSent.setStatusCode(500);
            customResponseOTPSent.setUserId(mobile);
            customResponseOTPSent.setMessage("Mobile number incorrect");
            log.warn("Invalid mobile number format: {}", mobile);
        }


        return customResponseOTPSent;
    }

}
