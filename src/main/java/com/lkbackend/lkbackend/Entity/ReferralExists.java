package com.lkbackend.lkbackend.Entity;



public class ReferralExists {
    private Data data;
    private int statusCode;
    private String userId;
    private String message;

    public ReferralExists(boolean isReferral, int statusCode, String userId, String message) {
        this.data = new Data(isReferral);
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    public ReferralExists() {
    }

    public ReferralExists(Data data, int statusCode, String userId, String message) {
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
        private boolean isReferralExists;

        public Data(){
        }

        public Data(boolean isDone) {
            this.isReferralExists = isDone;
        }

        public boolean isReferralExists() {
            return isReferralExists;
        }

        public void setReferralExists(boolean referral) {
            this.isReferralExists = referral;
        }


    }
}

