package br.com.gestaologistica.api_gestaologistica.adapters.config;

import br.com.gestaologistica.api_gestaologistica.domain.entities.Entrega;
import br.com.gestaologistica.api_gestaologistica.domain.repositories.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AtualizacaoCoordenadas {
    @Autowired
    private EntregaRepository entregaRepository;

    @Scheduled(fixedRate = 10000) // Atualização a cada 10 segundos
    public void atualizarCoordenadas() {
        List<Entrega> entregas = entregaRepository.buscarTodas();

        for (Entrega entrega : entregas) {
            if ("Em andamento".equals(entrega.getStatus())) {
                // Simulação de atualização de coordenadas
                entrega.setLatitudeAtual(entrega.getLatitudeAtual() + 0.01);
                entrega.setLongitudeAtual(entrega.getLongitudeAtual() + 0.01);
                entrega.setUltimaAtualizacao(LocalDateTime.now());

                // Verifica se a entrega chegou ao destino
                if (entrega.getLatitudeAtual() >= entrega.getDestinoLatitude() &&
                        entrega.getLongitudeAtual() >= entrega.getDestinoLongitude()) {
                    entrega.setStatus("Entregue");
                }

                // Persiste as alterações no repositório
                entregaRepository.salvar(entrega);
            }
        }
    }

}
