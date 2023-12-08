package com.tub;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publishQrCode(@RequestParam Map<String, String> body) {
        for (Map.Entry<String, String> entry : body.entrySet()) {
            kafkaTemplate.send("qrcode", entry.getKey());
        }

    }

    /*@PostMapping
    public void publishPedidoHistorico(@RequestParam Map<String, String> body) {
        for (Map.Entry<String, String> entry : body.entrySet()) {
            kafkaTemplate.send("historicoViagem", entry.getKey());
        }

    }*/
}
