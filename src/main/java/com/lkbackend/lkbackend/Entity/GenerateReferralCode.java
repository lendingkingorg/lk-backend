package com.lkbackend.lkbackend.Entity;

import java.security.SecureRandom;
import java.util.Base64;

public class GenerateReferralCode {

    public GenerateReferralCode(){}

    public String generateReferralCode() {
        byte[] bytes = new byte[8];
        new SecureRandom().nextBytes(bytes);

        String encoded = Base64.getEncoder().encodeToString(bytes);

        String stripped = encoded.replace("=", "").replace("+", "").replace("/", "");

        return stripped;
    }
}
