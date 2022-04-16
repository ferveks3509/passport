package ru.mailsend.controll;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaController {

    @KafkaListener(topics = {"expiredPassport"})
    public void onApiCall(ConsumerRecord<Integer, String> input) {
        System.out.println(input.topic());
        System.out.println(input.partition());
        System.out.println(input.value());
    }
}