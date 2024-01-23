package com.lkbackend.lkbackend.Entity;

import java.security.SecureRandom;
import java.util.Base64;

public class GenerateReferralCode {

    public GenerateReferralCode(){}

    public static String generateReferralCode() {
        byte[] bytes = new byte[4]; // Using half the number of bytes for a 6-character code
        new SecureRandom().nextBytes(bytes);

        String encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);

        return encoded.substring(0, 6);
    }
}
