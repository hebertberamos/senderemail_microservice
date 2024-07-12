package com.microserviceprojects.emailsender.senders;

import com.microserviceprojects.emailsender.entities.Email;
import com.microserviceprojects.emailsender.entities.enums.StatusEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class EmailSender {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(Email emailModel) { //Sending email
        emailModel.setSendDateEmail(Instant.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        }
        catch(MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
            System.out.println("MailException error:"+  e.getMessage());
        }
//        finally{ // =>  Turn on when exist a configured database
//            return emailRepository.save(emailModel);
//        }
    }

}
