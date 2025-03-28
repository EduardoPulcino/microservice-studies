package com.example.consumer01.service;

import com.example.consumer01.record.OrderRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @KafkaListener(topicPartitions = @TopicPartition(topic = "orders-process", partitions = { "0" }), containerFactory = "orderKafkaListenerContainerFactory")
    public void OrderListener(OrderRecord order) {
        System.out.println("Received Message Consumer 01: " +order.name());
    }
}
