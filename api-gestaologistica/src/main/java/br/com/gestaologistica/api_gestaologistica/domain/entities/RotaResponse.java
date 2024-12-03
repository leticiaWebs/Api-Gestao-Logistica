package br.com.gestaologistica.api_gestaologistica.domain.entities;

public class RotaResponse {

    private double distancia;
    private double tempoEstimado;

    public RotaResponse(double distancia, double tempoEstimado) {
        this.distancia = distancia;
        this.tempoEstimado = tempoEstimado;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
}
