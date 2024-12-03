package br.com.gestaologistica.api_gestaologistica.domain.entities;

public class CoordenadasRequest {
    private String pedidoId;
    private double latitudeAtual;
    private double longitudeAtual;

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
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
}
