package com.ameda.kisevu.apacheschemaregistry.consumer;/*
*
@author ameda
@project apache-schema-registry
*
*/

import com.ameda.kisevu.apacheschemaregistry.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {


    @KafkaListener(topics = {"${topic.name}"})
    public void readMessages(ConsumerRecord<String, Employee> consumerRecord){
        String key = consumerRecord.key();
        Employee employee = consumerRecord.value();
        log.info("Avro message received key:{} and value:{}",key,employee.toString());
    }
}
