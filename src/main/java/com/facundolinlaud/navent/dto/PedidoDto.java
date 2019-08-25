package com.facundolinlaud.navent.dto;

public class PedidoDto {
    private String nombre;
    private int monto;
    private int descuento;

    public PedidoDto() {}

    public PedidoDto(String nombre, int monto, int descuento) {
        this.nombre = nombre;
        this.monto = monto;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
