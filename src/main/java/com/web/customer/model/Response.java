package com.web.customer.model;

public class Response {
    private int responseCode;
    private String message;
    private Object object;
    public Response(int code, String message, Object object) {
        this.responseCode=code;
        this.message=message;
        this.object=object;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
