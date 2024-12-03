package br.com.gestaologistica.api_gestaologistica.domain.repositories;

import br.com.gestaologistica.api_gestaologistica.domain.entities.Entrega;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EntregaRepository {

    private final Map<String, Entrega> entregas = new HashMap<>();

    public void salvar(Entrega entrega) {
        entregas.put(entrega.getIdPedido(), entrega);
    }

    public Entrega buscarPorIdPedido(String idPedido) {
        return entregas.get(idPedido);
    }
    public List<Entrega> buscarTodas() {
        return new ArrayList<>(entregas.values());
    }
}
