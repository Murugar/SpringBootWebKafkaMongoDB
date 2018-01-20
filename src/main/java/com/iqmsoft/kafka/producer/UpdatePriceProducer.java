package com.iqmsoft.kafka.producer;


public interface UpdatePriceProducer {

    void updateDataPriceAndPublishToKafka(String id, double price);
}
