package com.microserviceprojects.emailsender.entities;

import com.microserviceprojects.emailsender.entities.enums.StatusEmail;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerReference; //Referencia do proprietário que está mandando a mensagem
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private Instant sendDateEmail;
    private StatusEmail statusEmail;

    public Email(){}

    public Email(Long id, String ownerReference, String emailFrom, String emailTo, String subject, String text, Instant sendDateEmail, StatusEmail statusEmail) {
        this.id = id;
        this.ownerReference = ownerReference;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
        this.statusEmail = statusEmail;
    }

    public Email(String ownerReference, String emailFrom, String emailTo, String subject, String text) {
        this.ownerReference = ownerReference;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerReference() {
        return ownerReference;
    }

    public void setOwnerReference(String ownerReference) {
        this.ownerReference = ownerReference;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(Instant sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
