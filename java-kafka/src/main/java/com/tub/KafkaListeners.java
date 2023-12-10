package com.tub;

import com.tub.models.Conta;
import com.tub.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    //private final ValidateQrCode validateQrCode = new ValidateQrCode();

    @Autowired
    private ContaRepository contaRepository;

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
    void validateQRCode(String data){//este listener ve quando existem novos qrcodes grcodes e vai verificar
        System.out.println("Listener Received <qrcode>: " + data + " !!");
        //String[] qrCodeInfoSeparated = data.split("\\,");

        //Pegar no json -> pegar na quantidade e preço e conseguir expor num endpoint GET.

        //System.out.println("id conta " + qrCodeInfoSeparated[0] + ",id cartao " + qrCodeInfoSeparated[1] + ", data: " + qrCodeInfoSeparated[2]);
        //validateQrCode.validadeQR(data);
/*
        Conta contaCriar = new Conta();
        contaCriar.setName("Francisco Borges");

        Cartao cartao = new Cartao();
        cartao.setValido(true);

        contaCriar.setCartao(cartao);

        contaRepository.save(contaCriar);*/

        Conta conta = contaRepository.findById(1).get();

        System.out.println(conta);
/*
        //validar a conta
        String contaId = qrCodeInfoSeparated[0];
        //validar o qr code
        String cartaoId = qrCodeInfoSeparated[1];
        //validar o tempo
        String dataQrCode = qrCodeInfoSeparated[2];

        Instant instant = Instant.parse(dataQrCode);

        LocalDateTime dateTime = LocalDateTime.parse(dataQrCode);*/
    }
}
