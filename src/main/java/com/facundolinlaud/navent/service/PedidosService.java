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

    public void delete(PedidoDto pedidoDto) {
        pedidosRepository.delete(new Pedido(pedidoDto));
    }

    public Pedido save(PedidoDto pedidoDto) {
        return pedidosRepository.save(new Pedido(pedidoDto));
    }
}
