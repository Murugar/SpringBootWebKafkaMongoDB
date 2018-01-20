package com.iqmsoft.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import com.iqmsoft.dao.InventoryRepository;
import com.iqmsoft.model.Inventory;


@Component
public class KafkaUpdatePriceProducer implements UpdatePriceProducer {

    @Autowired
    private InventoryRepository repository;

   
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Value("${api.kafka.topic}")
    String kafkaTopic = "api-kafka-topic";
    

    @Override
    public void updateDataPriceAndPublishToKafka(String id, double price) {

        Inventory inventory = repository.findById(id).get();
        //check if new price < old price (diskon)
        //send to kafka
        if(price < inventory.getPrice()){
            Message<?> content = new GenericMessage<String>(Double.toString(price));
          
            kafkaTemplate.send(kafkaTopic, Double.toString(price));
            
        }
        repository.updatePriceProduct(id, price);
    }
}
