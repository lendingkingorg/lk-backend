package com.lkbackend.lkbackend.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class SendOTPController {

    private static final String MSG91_API_URL = "https://control.msg91.com/api/v5/otp";
    private static final String MSG91_AUTH_KEY = "YourMSG91AuthKey"; // Replace with your actual MSG91 authkey

    private static final String MSG91_API_URL_v = "https://control.msg91.com/api/v5/otp/verify";

    @PostMapping("/send-otp")
    public String sendOTP(@RequestParam String mobile) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authkey","410480ArZD05k4xV6566f67eP1");
        //headers.set("6566f66ad6fc05476e020572", "template_id");

        String requestBody = "{\"Param1\":\"value1\",\"Param2\":\"value2\",\"Param3\":\"value3\"}";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                MSG91_API_URL + "?mobile=" + mobile + "&template_id=6566f66ad6fc05476e020572",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        return responseEntity.getBody();
    }

    @GetMapping("verify-otp")
    public String verifyOTP(@RequestParam String mobile, @RequestParam int otp) {
        // Replace "Enter your MSG91 authkey" with your actual MSG91 authkey
        String authKey = "410480ArZD05k4xV6566f67eP1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("authkey", authKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // You may need to replace "otp" with the actual OTP parameter name used by MSG91
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                MSG91_API_URL_v + "?mobile=" + mobile + "&" + "otp=" + otp,
                HttpMethod.GET,
                null,
                String.class
        );

        return responseEntity.getBody();
    }
}
