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

    public ErrorMessages getErrorMessages() {
        return ErrorMessages;
    }

    public void setErrorMessages(ErrorMessages errorMessages) {
        ErrorMessages = errorMessages;
    }

    public Messages getMessages() {
        return Messages;
    }

    public void setMessages(Messages messages) {
        Messages = messages;
    }

    public ResponseData getResponseData() {
        return ResponseData;
    }

    public void setResponseData(ResponseData responseData) {
        ResponseData = responseData;
    }
}
