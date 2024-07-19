package com.microserviceprojects.emailsender.senders;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsSender {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    public void sendSms(String recipientNumber, String text){
        Twilio.init(accountSid, authToken);

        Message.creator(
                new PhoneNumber(recipientNumber),
                new PhoneNumber(phoneNumber),
                text
        ).create();
    }
}
