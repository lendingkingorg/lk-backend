package com.lkbackend.lkbackend.Entity;

public class ForgotMpin {
    private Data data;
    private int statusCode;
    private String userId;
    private String message;

    public ForgotMpin(boolean otpSent, int statusCode, String userId, String message) {
        this.data = new Data(otpSent);
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    public ForgotMpin() {
    }

    public ForgotMpin(ForgotMpin.Data data, int statusCode, String userId, String message) {
        this.data = data;
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    // Getters and setters

    public ForgotMpin.Data getData() {
        return data;
    }

    public void setData(ForgotMpin.Data data) {
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
        private boolean forgotMpinEmailSent;

        public Data(){
        }

        public Data(boolean isDone) {
            this.forgotMpinEmailSent = isDone;
        }

        public boolean isForgotMpinEmailSent() {
            return forgotMpinEmailSent;
        }

        public void setForgotMpinEmailSent(boolean otp_verified) {
            this.forgotMpinEmailSent = otp_verified;
        }


    }
}
