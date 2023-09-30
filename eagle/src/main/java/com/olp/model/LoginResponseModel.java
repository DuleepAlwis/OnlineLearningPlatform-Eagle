package com.olp.model;

public class LoginResponseModel {

    private String responseMessage;
    private boolean responseStatus;

    private String token;

    public LoginResponseModel() {
    }

    public LoginResponseModel(String responseMessage, boolean responseStatus, String token) {
        this.responseMessage = responseMessage;
        this.responseStatus = responseStatus;
        this.token = token;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponseModel{" +
                "responseMessage='" + responseMessage + '\'' +
                ", responseStatus='" + responseStatus + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
