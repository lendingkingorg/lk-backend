package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.ForgotMpin;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class ForgetMpinController {

    private final LendingInfoService lendingInfoService;
    @Value("${msg91.send-email-url}")
    private String msg91ApiUrl;

    @Value("${msg91.authkey}")
    String authKey;
    @PostMapping("/recovery-mpin")
    public ForgotMpin forgetMpin(@RequestParam long mobile){
        ForgotMpin forgotMpin = new ForgotMpin();
        ForgotMpin.Data data = new ForgotMpin.Data();
        forgotMpin.setData(data);
        try {



            LendingInfo userInfo = lendingInfoService.findByMobileNumber(mobile);

            // Create JSON body as a string
            String jsonBody = "{\n" +
                    "  \"recipients\": [\n" +
                    "    {\n" +
                    "      \"to\": [\n" +
                    "        {\n" +
                    "          \"name\": \"" + userInfo.getName() + "\",\n" +
                    "          \"email\": \"" + userInfo.getEmail() + "\"\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"variables\": {\n" +
                    "        \"MPIN\": \"" + userInfo.getmPin() + "\",\n" +
                    "        \"USER\": \"" + userInfo.getName() + "\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"from\": {\n" +
                    "    \"name\": \"Support\",\n" +
                    "    \"email\": \"support@mail.lendingking.in\"\n" +
                    "  },\n" +
                    "  \"domain\": \"mail.lendingking.in\",\n" +
                    "  \"template_id\": \"forgot_mpin\"\n" +
                    "}";

            HttpHeaders headers = new HttpHeaders();
            headers.set("authkey", authKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            String mob = Long.toString(mobile);


            HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

            ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                    msg91ApiUrl,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            forgotMpin.setMessage("Email sent");
            data.setForgotMpinEmailSent(true);
            forgotMpin.setStatusCode(200);
            forgotMpin.setUserId(String.valueOf(mobile));
            return forgotMpin;
        } catch (Exception e) {
            e.printStackTrace();
            forgotMpin.setUserId(String.valueOf(mobile));
            data.setForgotMpinEmailSent(false);
            forgotMpin.setStatusCode(400);
            forgotMpin.setMessage("Email not found");
            return forgotMpin;

        }
    }
}
