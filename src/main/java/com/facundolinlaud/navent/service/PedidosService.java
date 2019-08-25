package com.facundolinlaud.navent.service;

import com.facundolinlaud.navent.dto.PedidoDto;
import com.facundolinlaud.navent.model.Pedido;
import com.facundolinlaud.navent.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepository;

    public List<Pedido> getAllPedidos(){
        return pedidosRepository.findAll();
    }

    public void delete(PedidoDto dto) {
        Pedido pedido = new Pedido(dto);
        pedidosRepository.delete(pedido);
    }

    public Pedido save(PedidoDto dto) {
        Pedido pedido = new Pedido(dto);
        return pedidosRepository.save(pedido);
    }
}
