package com.hospital.Response;

import org.springframework.stereotype.Component;

@Component
public class Messages {

    private String messages;

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
