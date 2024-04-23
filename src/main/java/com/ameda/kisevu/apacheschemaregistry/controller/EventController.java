package com.ameda.kisevu.apacheschemaregistry.controller;/*
*
@author ameda
@project apache-schema-registry
*
*/

import com.ameda.kisevu.apacheschemaregistry.dto.Employee;
import com.ameda.kisevu.apacheschemaregistry.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private KafkaAvroProducer producer;


    @PostMapping("/events")
    public String sendMessage(@RequestBody Employee employee){
        producer.send(employee);
        return "message successfully sent";
    }
}
