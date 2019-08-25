package com.facundolinlaud.navent.model;

import com.facundolinlaud.navent.dto.PedidoDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Pedido {
    @Id
    @GeneratedValue
    private int idPedido;
    @Size(max = 100)
    private String nombre;
    private int monto;
    private int descuento;

    public Pedido() { }

    public Pedido(@Size(max = 100) String nombre, int monto, int descuento) {
        this.nombre = nombre;
        this.monto = monto;
        this.descuento = descuento;
    }

    public Pedido(PedidoDto dto){
        this(dto.getNombre(), dto.getMonto(), dto.getDescuento());
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
