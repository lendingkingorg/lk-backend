package com.lkbackend.lkbackend.Entity;

public class CustomerResponseAccountCreate {
    private Data data;
    private int statusCode;
    private String userId;
    private String message;

    public CustomerResponseAccountCreate(boolean otpSent, int statusCode, String userId, String message) {
        this.data = new CustomerResponseAccountCreate.Data(otpSent);
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    public CustomerResponseAccountCreate() {
    }

    public CustomerResponseAccountCreate(CustomerResponseAccountCreate.Data data, int statusCode, String userId, String message) {
        this.data = data;
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    // Getters and setters

    public CustomerResponseAccountCreate.Data getData() {
        return data;
    }

    public void setData(CustomerResponseAccountCreate.Data data) {
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
        private boolean isAccountCreated;

        public Data(){
        }

        public Data(boolean isDone) {
            this.isAccountCreated = isDone;
        }

        public boolean isAccountCreated() {
            return isAccountCreated;
        }

        public void setAccountCreated(boolean isAccountCreated) {
            this.isAccountCreated = isAccountCreated;
        }


    }
}
