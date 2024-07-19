package com.microserviceprojects.emailsender.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue.email}")
    private String emailQueue;

    @Value("${spring.rabbitmq.queue.sms}")
    private String smsQueue;

    // =>  Generate a new queue
    @Bean
    public Queue emailQueue(){
        return new Queue(emailQueue, true);
    }

    @Bean
    public Queue smsQueue(){
        return new Queue(smsQueue, true);
    }

    // =>  Global converter to receive the EmailDTO
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
