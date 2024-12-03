package br.com.gestaologistica.api_gestaologistica.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Entrega {
    private String idPedido;
    private String origem;
    private String destino;
    private double distanciaEstimada;
    private double tempoEstimado;
    private String status; // "Pendente", "Em andamento", "Entregue"
    private LocalDateTime ultimaAtualizacao;
    private double latitudeAtual;
    private double longitudeAtual;
    private double destinoLatitude;
    private double destinoLongitude;

    public Entrega(String idPedido, String origem, String destino, double distanciaEstimada, double tempoEstimado, String status, LocalDateTime ultimaAtualizacao, double latitudeAtual, double longitudeAtual, double destinoLatitude, double destinoLongitude) {
        this.idPedido = idPedido;
        this.origem = origem;
        this.destino = destino;
        this.distanciaEstimada = distanciaEstimada;
        this.tempoEstimado = tempoEstimado;
        this.status = status;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.latitudeAtual = latitudeAtual;
        this.longitudeAtual = longitudeAtual;
        this.destinoLatitude = destinoLatitude;
        this.destinoLongitude = destinoLongitude;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

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

    public double getDistanciaEstimada() {
        return distanciaEstimada;
    }

    public void setDistanciaEstimada(double distanciaEstimada) {
        this.distanciaEstimada = distanciaEstimada;
    }

    public double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public double getLatitudeAtual() {
        return latitudeAtual;
    }

    public void setLatitudeAtual(double latitudeAtual) {
        this.latitudeAtual = latitudeAtual;
    }

    public double getLongitudeAtual() {
        return longitudeAtual;
    }

    public void setLongitudeAtual(double longitudeAtual) {
        this.longitudeAtual = longitudeAtual;
    }

    public double getDestinoLatitude() {
        return destinoLatitude;
    }

    public void setDestinoLatitude(double destinoLatitude) {
        this.destinoLatitude = destinoLatitude;
    }

    public double getDestinoLongitude() {
        return destinoLongitude;
    }

    public void setDestinoLongitude(double destinoLongitude) {
        this.destinoLongitude = destinoLongitude;
    }
}
