package com.microserviceprojects.emailsender.consumers;

import com.microserviceprojects.emailsender.senders.EmailSender;
import com.microserviceprojects.emailsender.dtos.EmailDto;
import com.microserviceprojects.emailsender.entities.Email;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailSender emailSender;

    @RabbitListener(queues = "${spring.rabbitmq.queue}") // Shows that it's a listener of a specific queue
    public void listen(@Payload EmailDto emailDto){
        Email emailModel = new Email();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailSender.sendEmail(emailModel);

        System.out.println("Email status: " + emailModel.getStatusEmail().toString());
    }
}
