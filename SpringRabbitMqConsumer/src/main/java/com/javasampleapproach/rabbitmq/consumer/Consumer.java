package com.javasampleapproach.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javasampleapproach.entity.Bank;



@Component
public class Consumer {

	@RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(Bank msg) {
        System.out.println("Recieved Message: " + msg);
    }
}
