package com.microserviceprojects.emailsender.dtos;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDto {

    @NotBlank(message = "Owner reference is mandatory")
    private String ownerReference;
    @NotBlank(message = "Email from is mandatory")
    @Email
    private String emailFrom;
    @NotBlank(message = "Email to is mandatory")
    @Email
    private String emailTo;
    @NotBlank(message = "Subject is mandatory")
    private String subject;
    @NotBlank(message = "Text message is mandatory")
    private String text;

    public EmailDto(String ownerReference, String emailFrom, String emailTo, String subject, String text) {
        this.ownerReference = ownerReference;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public EmailDto(com.microserviceprojects.emailsender.entities.Email entity){
        ownerReference = entity.getOwnerReference();
        emailFrom = entity.getEmailFrom();
        emailTo = entity.getEmailTo();
        subject = entity.getSubject();
        text = entity.getText();
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
}
