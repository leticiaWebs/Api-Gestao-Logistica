package br.com.gestaologistica.api_gestaologistica.adapters.config.listener;

import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class KafkaListenerService {

    private static final Logger log = LoggerFactory.getLogger(KafkaListenerService.class);

    @Bean
    public Consumer<KStream<Object, String>> listenMessages() {
        return input -> input.foreach((key, value) -> {
            // Verifica se a mensagem está no formato esperado antes de dividir
            if (value != null && value.contains(";")) {
                var msgParts = value.split(";");
                log.info("Will perform a {} with content {}", msgParts[0], msgParts[1]);
            } else {
                log.warn("Received invalid message: {}", value);
            }
        });
    }
}
