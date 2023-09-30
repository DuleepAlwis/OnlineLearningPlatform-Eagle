package com.olp.model;

public class GeneralResponseModel {

    private String responseMessage;
    private boolean responseStatus;

    public GeneralResponseModel() {
    }

    public GeneralResponseModel(String responseMessage, boolean responseStatus) {
        this.responseMessage = responseMessage;
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean isResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString() {
        return "GeneralResponseModel{" +
                "responseMessage='" + responseMessage + '\'' +
                ", responseStatus=" + responseStatus +
                '}';
    }
}
