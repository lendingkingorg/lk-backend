package com.lkbackend.lkbackend.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CustomResponseOTPVerify {
    private Data data;
    private int statusCode;
    private long userId;
    private String message;

    public CustomResponseOTPVerify(boolean otpVerified, boolean customerExists, int mpin, int statusCode, long userId, String message, UUID sessionId, String email) {
        this.data = new Data(sessionId,email,otpVerified, new Info(customerExists, mpin));
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    public CustomResponseOTPVerify() {
    }

    public Data getData() {
        return data;
    }


    public void setData(Data data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Data {
        private boolean otpVerified;
        private Info info;

        public UUID sessionId;

        public String email;

        public Data(){}

        public Data(UUID sessionId, String email, boolean otpVerified, Info info) {
            this.otpVerified = otpVerified;
            this.email = email;
            this.sessionId = sessionId;
            this.info = info;
        }

        public boolean isOtpVerified() {
            return otpVerified;
        }

        public void setOtpVerified(boolean otpVerified) {
            this.otpVerified = otpVerified;
        }

        public UUID getSessionId() {
            return sessionId;
        }

        public void setSessionId(UUID sessionId) {
            this.sessionId = sessionId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }
        // Getters and setters
    }

    @Setter
    @Getter
    public static class Info {
        private boolean customerExists;
        private int mpin;
        private String userName;


        public Info(boolean customerExists, int mpin) {
            this.customerExists = customerExists;
            this.mpin = mpin;
        }

        public boolean isCustomerExists() {
            return customerExists;
        }

        public void setCustomerExists(boolean customerExists) {
            this.customerExists = customerExists;
        }

        public int getMpin() {
            return mpin;
        }

        public void setMpin(int mpin) {
            this.mpin = mpin;
        }

        public Info() {
        }

    }
}
