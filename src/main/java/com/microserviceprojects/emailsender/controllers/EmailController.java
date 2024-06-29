package com.microserviceprojects.emailsender.controllers;


import com.microserviceprojects.emailsender.dtos.EmailDto;
import com.microserviceprojects.emailsender.entities.Email;
import com.microserviceprojects.emailsender.servicies.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping
    public ResponseEntity<List<EmailDto>> verifyAllEmails(){
        List<EmailDto> allEmails = emailService.allEmails();
        return ResponseEntity.ok().body(allEmails);
    }

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        Email emailModel = new Email();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
