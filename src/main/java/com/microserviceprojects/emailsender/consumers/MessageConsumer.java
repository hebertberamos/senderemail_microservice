package com.microserviceprojects.emailsender.consumers;

import com.microserviceprojects.emailsender.dtos.SmsDto;
import com.microserviceprojects.emailsender.senders.EmailSender;
import com.microserviceprojects.emailsender.dtos.EmailDto;
import com.microserviceprojects.emailsender.entities.Email;
import com.microserviceprojects.emailsender.senders.SmsSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private SmsSender smsSender;

    @RabbitListener(queues = "${spring.rabbitmq.queue.email}") // Shows that it's a listener of a specific queue
    public void listen(@Payload EmailDto emailDto){
        Email emailModel = new Email();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailSender.sendEmail(emailModel);

        System.out.println("Email status: " + emailModel.getStatusEmail().toString());
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.sms}")
    public void smsListener(@Payload SmsDto smsDto){
        smsSender.sendSms(smsDto.getRecipientNumber(), smsDto.getText());
    }
}
