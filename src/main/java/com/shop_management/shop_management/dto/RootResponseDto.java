package com.shop_management.shop_management.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class RootResponseDto implements Serializable {
    private boolean success;
    private String errorMessaage;
    private String message;
    private Serializable body;


    public RootResponseDto(boolean success,
                           String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public <T> RootResponseDto(boolean success, T body) {
        this.success = success;
        this.body = new ArrayList<T>();
        ((ArrayList) this.body).add(body);
    }


    public <T> RootResponseDto(boolean success, String message, T body) {
        this.success = success;
        this.message = message;
        this.body = new ArrayList<T>();
        ((ArrayList) this.body).add(body);
    }


    public boolean isSuccess() {

        return success;
    }

    public void setSuccess(boolean success) {

        this.success = success;
    }

    public String getErrorMessaage() {

        return errorMessaage;
    }

    public void setErrorMessaage(String errorMessaage) {

        this.errorMessaage = errorMessaage;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public Serializable getBody() {

        return body;
    }

    public void setBody(Serializable body) {

        this.body = body;
    }
}
