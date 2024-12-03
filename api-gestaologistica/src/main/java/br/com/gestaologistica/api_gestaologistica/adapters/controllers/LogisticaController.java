package br.com.gestaologistica.api_gestaologistica.adapters.controllers;

import br.com.gestaologistica.api_gestaologistica.domain.entities.CoordenadasRequest;
import br.com.gestaologistica.api_gestaologistica.domain.entities.Entrega;
import br.com.gestaologistica.api_gestaologistica.domain.entities.RotaRequest;
import br.com.gestaologistica.api_gestaologistica.domain.entities.RotaResponse;
import br.com.gestaologistica.api_gestaologistica.domain.repositories.EntregaRepository;
import br.com.gestaologistica.api_gestaologistica.domain.services.LogisticaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/logistica")
public class LogisticaController {

    @Autowired
    private LogisticaService logisticaService;

    @Autowired
    private EntregaRepository entregaRepository;


    public LogisticaController(LogisticaService logisticaService) {
        this.logisticaService = logisticaService;
    }

    @PostMapping("/iniciarEntrega")
    public ResponseEntity<Entrega> iniciarEntrega(@RequestBody Entrega entrega) {
        try {
            double distancia = logisticaService.calcularDistanciaEntreCidades(entrega.getOrigem(), entrega.getDestino());
            double tempoEstimado = logisticaService.calcularTempoEstimado(distancia);

            entrega.setDistanciaEstimada(distancia);
            entrega.setTempoEstimado(tempoEstimado);
            entrega.setStatus("Em andamento");
            entregaRepository.salvar(entrega);

            return ResponseEntity.ok(entrega);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{idPedido}/status")
    public ResponseEntity<Entrega> obterStatus(@PathVariable String idPedido) {
        Entrega entrega = entregaRepository.buscarPorIdPedido(idPedido);
        if (entrega == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entrega);
    }
    @PostMapping("/calcular-rota")
    public ResponseEntity<?> calcularRota(@Valid @RequestBody RotaRequest rotaRequest) {
        try {
            // Calcula distância entre origem e destino
            double distancia = logisticaService.calcularDistanciaEntreCidades(rotaRequest.getOrigem(), rotaRequest.getDestino());

            // Calcula o tempo estimado com base na distância
            double tempoEstimado = logisticaService.calcularTempoEstimado(distancia);

            // Retorna os resultados como resposta
            RotaResponse rotaResponse = new RotaResponse(distancia, tempoEstimado);
            return ResponseEntity.ok(rotaResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Dados inválidos: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao calcular a rota.");
        }
    }
        @PutMapping("/atualizar-coordenadas")
        public ResponseEntity<?> atualizarCoordenadas(@RequestBody CoordenadasRequest coordenadasRequest) {
            try {
                // Busca a entrega pelo pedidoId
                Entrega entrega = entregaRepository.buscarPorIdPedido(coordenadasRequest.getPedidoId());

                if (entrega == null) {
                    return ResponseEntity.notFound().build();
                }

                // Atualiza as coordenadas da entrega
                entrega.setLatitudeAtual(coordenadasRequest.getLatitudeAtual());
                entrega.setLongitudeAtual(coordenadasRequest.getLongitudeAtual());

                // Salva a entrega atualizada no repositório
                entregaRepository.salvar(entrega);

                return ResponseEntity.ok(entrega);
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Erro ao atualizar coordenadas.");
            }
        }
    }

