package com.lkbackend.lkbackend.entity;

public class VerifyResponseBody {
        private String message;
        private String type;

        // Constructor
        public VerifyResponseBody(String message, String type) {
            this.message = message;
            this.type = type;
        }

        // Getter methods
        public String getMessage() {
            return message;
        }

        public String getType() {
            return type;
        }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" + '\"' +
                "message" + '\"' +':'+ '\"' + message + '\"' +
                ','+ '\"'+ "type" + '\"' +':'+ '\"' + type + '\"' +
                '}';
    }
}
