package com.microserviceprojects.emailsender.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_sms")
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String recipientNumber;
    private String text;


    public Sms(){}

    public Sms(String recipientNumber, String text) {
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
