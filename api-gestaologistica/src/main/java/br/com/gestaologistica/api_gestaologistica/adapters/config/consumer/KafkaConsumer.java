package br.com.gestaologistica.api_gestaologistica.adapters.config.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "pedidos", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
