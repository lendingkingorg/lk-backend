package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Entity.ForgotMpin;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping
public class ForgetMpinController {

    private final LendingInfoService lendingInfoService;

    public ForgetMpinController(LendingInfoService lendingInfoService) {
        this.lendingInfoService = lendingInfoService;
    }

    @PostMapping("/recovery-mpin")
    public ForgotMpin ForgetMpin(@RequestParam long mobile){
        ForgotMpin forgotMpin = new ForgotMpin();
        ForgotMpin.Data data = new ForgotMpin.Data();
        forgotMpin.setData(data);
        try {



            LendingInfo user_info = lendingInfoService.findByMobileNumber(mobile);


            // Set the API endpoint URL
            String apiUrl = "https://control.msg91.com/api/v5/email/send";

            // Create JSON body as a string
            String jsonBody = "{\n" +
                    "  \"recipients\": [\n" +
                    "    {\n" +
                    "      \"to\": [\n" +
                    "        {\n" +
                    "          \"name\": \"" + user_info.getName() + "\",\n" +
                    "          \"email\": \"" + user_info.getEmail() + "\"\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"variables\": {\n" +
                    "        \"MPIN\": \"" + user_info.getmPin() + "\",\n" +
                    "        \"USER\": \"" + user_info.getName() + "\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"from\": {\n" +
                    "    \"name\": \"Support\",\n" +
                    "    \"email\": \"support@mail.lendingking.in\"\n" +
                    "  },\n" +
                    "  \"domain\": \"mail.lendingking.in\",\n" +
                    "  \"template_id\": \"welcome_template_2\"\n" +
                    "}";

            // Create an HTTP client
            String authKey = "410480ArZD05k4xV6566f67eP1";

            HttpHeaders headers = new HttpHeaders();
            headers.set("authkey", authKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            String mob = Long.toString(mobile);


            HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

            ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                    apiUrl,
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
