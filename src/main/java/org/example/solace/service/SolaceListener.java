package org.example.solace.service;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class SolaceListener{

    @JmsListener(destination = "testQueue", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(Message message, MessageHeaders messageHeaders) throws JMSException{
        System.out.println(message.getJMSDestination());
    }

}
