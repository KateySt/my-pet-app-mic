package org.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(id = "my_consumer", topics = "topic", clientIdPrefix = "my_clientId")
    public void listen(String data) {
        System.out.println("kafka message "+data);
    }

}
