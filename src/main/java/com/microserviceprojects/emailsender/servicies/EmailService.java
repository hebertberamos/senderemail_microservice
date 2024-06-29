package com.microserviceprojects.emailsender.servicies;

import com.microserviceprojects.emailsender.dtos.EmailDto;
import com.microserviceprojects.emailsender.entities.Email;
import com.microserviceprojects.emailsender.entities.enums.StatusEmail;
import com.microserviceprojects.emailsender.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

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

    @Transactional(readOnly = true)
    public List<EmailDto> allEmails() {
        List<Email> allEmails = emailRepository.findAll();
        return allEmails.stream().map(x -> new EmailDto(x)).collect(Collectors.toList());
    }
}
