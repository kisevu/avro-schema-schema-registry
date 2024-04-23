package com.ameda.kisevu.apacheschemaregistry.producer;/*
*
@author ameda
@project apache-schema-registry
*
*/

import com.ameda.kisevu.apacheschemaregistry.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaAvroProducer {
    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;
    @Value("${topic.name}")
    private String topicName;

    /*
    *
    * sending avro object as Employee
    * */
        public void send(Employee employee){
            CompletableFuture<SendResult<String, Employee>> sentObject
                    = kafkaTemplate.send(topicName, employee);
            sentObject.whenComplete((result,ex)->{
                if(ex==null){
                    System.out.println("sent message:[" + employee+
                            "] with offset=["+result.getRecordMetadata().offset()+"]");
                }else{
                    System.out.println("Unable to send message=["+
                            employee + "] due to : "+ex.getMessage());
                }
            });
        }

}
