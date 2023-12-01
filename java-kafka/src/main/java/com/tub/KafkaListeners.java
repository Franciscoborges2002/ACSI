package com.tub;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "teste",
            groupId = "groupId"
    )
    void listener(String data){
        System.out.println("Listener Received <teste>: " + data + " !!");
    }

    @KafkaListener(
            topics = "qrcode",
            groupId = "groupId"
    )
    void validateQRCode(String data){
        System.out.println("Listener Received <qrcode>: " + data + " !!");
    }
}
