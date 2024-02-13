package com.lkbackend.lkbackend.entity;

public class CustomerResponseAccountCreate {
    private Data data;
    private int statusCode;
    private long userId;
    private String message;

    public CustomerResponseAccountCreate(boolean otpSent, int statusCode, long userId, String message) {
        this.data = new CustomerResponseAccountCreate.Data(otpSent);
        this.statusCode = statusCode;
        this.userId = userId;
        this.message = message;
    }

    public CustomerResponseAccountCreate() {
    }

    public CustomerResponseAccountCreate(CustomerResponseAccountCreate.Data data, int statusCode, long userId, String message) {
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
