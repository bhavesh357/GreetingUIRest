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
}
