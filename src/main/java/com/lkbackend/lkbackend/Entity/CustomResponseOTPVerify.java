package com.lkbackend.lkbackend.Entity;

import javax.swing.plaf.PanelUI;

public class CustomResponseOTPVerify {
    private Data data;
    private int statusCode;
    private String userId;
    private String message;

    public CustomResponseOTPVerify(boolean otpVerified, boolean customerExists, int mpin, int statusCode, String userId, String message) {
        this.data = new Data(otpVerified, new Info(customerExists, mpin));
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

        public Data(){}

        public Data(boolean otpVerified, Info info) {
            this.otpVerified = otpVerified;
            this.info = info;
        }

        public boolean isOtpVerified() {
            return otpVerified;
        }

        public void setOtpVerified(boolean otpVerified) {
            this.otpVerified = otpVerified;
        }

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }
        // Getters and setters
    }

    public static class Info {
        private boolean customerExists;
        private int mpin;


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
