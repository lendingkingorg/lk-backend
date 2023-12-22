package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.CustomResponseOTPSent;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class SendOTPController {

    private static final String MSG91_API_URL = "https://control.msg91.com/api/v5/otp";

    @PostMapping("/send-otp")
    public CustomResponseOTPSent sendOTP(@RequestParam String mobile) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authkey","410480ArZD05k4xV6566f67eP1");
        headers.set("6566f66ad6fc05476e020572", "template_id");

        String requestBody = "";

        CustomResponseOTPSent customResponseOTPSent = new CustomResponseOTPSent();
        CustomResponseOTPSent.Data data = new CustomResponseOTPSent.Data();

        customResponseOTPSent.setData(data);

        if(mobile.length()==12) {

            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    MSG91_API_URL + "?mobile=" + mobile + "&template_id=6566f66ad6fc05476e020572",
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );


            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                data.setOtp_verified(true);
                customResponseOTPSent.setStatusCode(200);
                customResponseOTPSent.setUserId(mobile);
                customResponseOTPSent.setMessage("MessageSuccessfully sent");


            } else {
                data.setOtp_verified(false);
                customResponseOTPSent.setStatusCode(400);
                customResponseOTPSent.setUserId(mobile);
                customResponseOTPSent.setMessage("Message unsuccessfull");
            }
        } else {
            data.setOtp_verified(false);
            customResponseOTPSent.setStatusCode(500);
            customResponseOTPSent.setUserId(mobile);
            customResponseOTPSent.setMessage("Mobile number incorrect");

        }


        return customResponseOTPSent;
    }

}
