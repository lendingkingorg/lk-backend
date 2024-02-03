package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Config.JwtTokenUtil;
import com.lkbackend.lkbackend.Entity.CustomerResponseAccountCreate;
import com.lkbackend.lkbackend.Entity.GenerateReferralCode;
import com.lkbackend.lkbackend.Entity.JWTResponse;
import com.lkbackend.lkbackend.Service.LendingInfoService;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CreateAccountController {

    @Autowired
    JwtTokenUtil helper;

    @Autowired
    private AuthenticationManager manager;

    private final LendingInfoService lendingInfoService;

    public CreateAccountController(LendingInfoService lendingInfoService) {
        this.lendingInfoService = lendingInfoService;
    }

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

        CustomerResponseAccountCreate customerResponseAccountCreate = new CustomerResponseAccountCreate();
        CustomerResponseAccountCreate.Data data = new CustomerResponseAccountCreate.Data();
        customerResponseAccountCreate.setData(data);
        data.setAccountCreated(true);
        customerResponseAccountCreate.setMessage("Account Successfully Created");
        customerResponseAccountCreate.setStatusCode(200);
        customerResponseAccountCreate.setUserId(mobile);


        this.doAuthenticate(name, mpin);

        String token = this.helper.generateToken(name);

        customerResponseAccountCreate.setToken(token);

        return customerResponseAccountCreate;

    }

    private void doAuthenticate(String email, int password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
