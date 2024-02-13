package com.lkbackend.lkbackend.entity;

public class CustomResponseOTPSent {
    private Data data;
    private int statusCode;
    private String userId;
    private String message;

    public CustomResponseOTPSent(boolean otpSent, int statusCode, String userId, String message) {
        this.data = new Data(otpSent);
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    public CustomResponseOTPSent() {
    }

    public CustomResponseOTPSent(Data data, int statusCode, String userId, String message) {
        this.data = data;
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    // Getters and setters

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

    public static class Data{
        private boolean otp_sent;

        public Data(){
        }

        public Data(boolean isDone) {
            this.otp_sent = isDone;
        }

        public boolean isOtp_sent() {
            return otp_sent;
        }

        public void setOtp_sent(boolean otp_verified) {
            this.otp_sent = otp_verified;
        }


    }
}
