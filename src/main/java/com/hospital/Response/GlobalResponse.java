package com.hospital.Response;

public class GlobalResponse {

    private boolean Success;
    private ErrorMessages ErrorMessages;
    private Messages Messages;
    private ResponseData ResponseData;

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public com.hospital.Response.ErrorMessages getErrorMessages() {
        return ErrorMessages;
    }

    public void setErrorMessages(com.hospital.Response.ErrorMessages errorMessages) {
        ErrorMessages = errorMessages;
    }

    public com.hospital.Response.Messages getMessages() {
        return Messages;
    }

    public void setMessages(com.hospital.Response.Messages messages) {
        Messages = messages;
    }

    public com.hospital.Response.ResponseData getResponseData() {
        return ResponseData;
    }

    public void setResponseData(com.hospital.Response.ResponseData responseData) {
        ResponseData = responseData;
    }
}
