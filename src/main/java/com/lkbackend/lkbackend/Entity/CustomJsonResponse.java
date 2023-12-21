package com.lkbackend.lkbackend.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomJsonResponse {
    private Data data;
    private int statuscode;
    private String userId;  // or mobile number or sessionId
    private String message;

    // Constructors, getters, and setters

    public CustomJsonResponse() {
    }

    public CustomJsonResponse(Data data, int statuscode, String userId, String message) {
        this.data = data;
        this.statuscode = statuscode;
        this.userId = userId;
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
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
        private boolean isDone;
        private Info info;

        // Constructors, getters, and setters

        public Data() {
        }

        public Data(boolean isDone, Info info) {
            this.isDone = isDone;
            this.info = info;
        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean done) {
            isDone = done;
        }

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }
    }

    public static class Info {
        private boolean isDone;

        // Constructors, getters, and setters

        public Info() {
        }

        public Info(boolean isDone) {
            this.isDone = isDone;
        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean done) {
            isDone = done;
        }
    }
}

