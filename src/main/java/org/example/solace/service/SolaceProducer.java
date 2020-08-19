package org.example.solace.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
public class SolaceProducer{

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendSolaceMessage() throws JsonProcessingException{

        Map<String, Object> map = new HashMap<>();
        map.put("testKey", "testValue");
        String payload = new ObjectMapper().writeValueAsString(map);
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setTargetConnectionFactory(jmsTemplate.getConnectionFactory());
        jmsTemplate.setConnectionFactory(factory);
        //jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        jmsTemplate.setPubSubDomain(false);
        jmsTemplate.convertAndSend("testQueue", payload);
    }

    /**@Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setTargetConnectionFactory(jmsTemplate.getConnectionFactory());
        jmsTemplate.setConnectionFactory(factory);
        //jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        jmsTemplate.setPubSubDomain(false);
        return jmsTemplate;
    }*/


}
