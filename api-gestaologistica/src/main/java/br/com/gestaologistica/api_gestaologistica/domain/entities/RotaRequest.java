package br.com.gestaologistica.api_gestaologistica.domain.entities;

public class RotaRequest {

    private String origem;
    private String destino;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
