package br.com.gestaologistica.api_gestaologistica.adapters.config.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {

    @KafkaListener(topics = "pedidos")
    public void listenMessages(String message){
        var msgParts  = message.split(":");
        log.info("Will perform a {} with content {}",msgParts[0], msgParts[1]);
    }
}
