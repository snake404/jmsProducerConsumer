package org.example.solace.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.solace.service.SolaceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class GenericController{

    @Autowired
    private SolaceProducer producer;

    @PostMapping(value = "/sendMessage")
    public ResponseEntity<Void> sendSolaceMessage() throws JsonProcessingException{
        producer.sendSolaceMessage();
        return ResponseEntity.ok().build();
    }

}
