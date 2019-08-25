package com.facundolinlaud.navent.dto;

public class PedidoDto {
    private String nombre;
    private float monto;
    private float descuento;

    public PedidoDto() {}

    public PedidoDto(String nombre, float monto, float descuento) {
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

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
}
