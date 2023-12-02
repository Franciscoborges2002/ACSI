package com.tub;

import com.tub.filters.ValidateQrCode;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private final ValidateQrCode validateQrCode = new ValidateQrCode();

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
    void validateQRCode(String data){//este listener ve quando existem novos qrcodes geraods e vai verificar
        System.out.println("Listener Received <qrcode>: " + data + " !!");
        validateQrCode.validadeQR(data);
    }
}
