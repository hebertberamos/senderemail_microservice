package com.microserviceprojects.emailsender.dtos;

public class SmsDto {
    private String recipientNumber;
    private String text;


    public SmsDto(){}

    public SmsDto(String recipientNumber, String text) {
        this.recipientNumber = recipientNumber;
        this.text = text;
    }

    public String getRecipientNumber() {
        return recipientNumber;
    }

    public void setRecipientNumber(String recipientNumber) {
        this.recipientNumber = recipientNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
