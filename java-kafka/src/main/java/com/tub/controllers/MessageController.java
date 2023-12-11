package com.tub.controllers;

import org.json.JSONObject;
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

    /*@PostMapping
    public void publishQrCode(@RequestBody String body, @RequestHeader Map<String, String> headers) {
        System.out.println("body: " + body);
        /*for (Map.Entry<String, String> entry : body.entrySet()) {
            kafkaTemplate.send("qrcode", entry.getKey());
        }

        headers.forEach((key, value) -> {
            System.out.println((String.format("Header '%s' = %s", key, value)));
        });

        body = body.replace("%2C", ",");

        System.out.println(body);

    }*/

    @PostMapping("/qrcode")
    public void publishQrCode(@RequestParam Map<String, String> body) {
        for (Map.Entry<String, String> entry : body.entrySet()) {
            System.out.println(entry);
            //
        }

        JSONObject json = new JSONObject();



        body.forEach((key, value) -> {
            json.put("message", key);

            kafkaTemplate.send("qrcode", json.toString());//enviar para o topico

            System.out.println((String.format("body '%s' = %s", key, value)));
        });


    }

    /*@PostMapping
    public void publishPedidoHistorico(@RequestParam Map<String, String> body) {
        for (Map.Entry<String, String> entry : body.entrySet()) {
            kafkaTemplate.send("historicoViagem", entry.getKey());
        }

    }*/
}
