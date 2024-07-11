package com.microserviceprojects.emailsender.consumers;

import com.microserviceprojects.emailsender.dtos.EmailDto;
import com.microserviceprojects.emailsender.entities.Email;
import com.microserviceprojects.emailsender.servicies.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    // =>  Method that will listen the queue
    @RabbitListener(queues = "${spring.rabbitmq.queue}") // To show tho the Spring that method is a listener of a queue
    public void listen(@Payload EmailDto emailDto){
        Email emailModel = new Email();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email status: " + emailModel.getStatusEmail().toString());
    }
}
