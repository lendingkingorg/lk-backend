package com.lkbackend.lkbackend.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class SendOTPController {

    private static final String MSG91_API_URL = "https://control.msg91.com/api/v5/otp";
    private static final String MSG91_AUTH_KEY = "YourMSG91AuthKey"; // Replace with your actual MSG91 authkey

    private static final String MSG91_API_URL_v = "https://control.msg91.com/api/v5/otp/verify";

    private static final String MSG91_API_URL_r = "https://control.msg91.com/api/v5/otp/retry?retrytype=text";

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

    @GetMapping("/verify-otp")
    public boolean verifyOTP(@RequestParam String mobile, @RequestParam int otp) {
        // Replace "Enter your MSG91 authkey" with your actual MSG91 authkey

        try{String authKey = "410480ArZD05k4xV6566f67eP1";

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
            // You may want to further parse the response JSON to check for success
            return true;
        } else {
            // Handle the case where the OTP verification failed
            return false;
        }
    } catch (RestClientException e) {
        // Handle exceptions, e.g., connection errors, timeouts, etc.
        e.printStackTrace();
        return false;
    }


    }

    @GetMapping("/resend-otp")
    public String resendOTP(@RequestParam String mobile) {
        // Replace "Enter your MSG91 authkey" with your actual MSG91 authkey
        String authKey = "410480ArZD05k4xV6566f67eP1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("authkey", authKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                MSG91_API_URL_r + "&mobile=" + mobile,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        return responseEntity.getBody();
    }


}
