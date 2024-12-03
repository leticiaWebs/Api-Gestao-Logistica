package br.com.gestaologistica.api_gestaologistica.adapters.controllers;

import br.com.gestaologistica.api_gestaologistica.domain.entities.Entrega;
import br.com.gestaologistica.api_gestaologistica.domain.repositories.EntregaRepository;
import br.com.gestaologistica.api_gestaologistica.domain.services.LogisticaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
