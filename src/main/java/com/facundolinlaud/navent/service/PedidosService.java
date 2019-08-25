package com.facundolinlaud.navent.service;

import com.facundolinlaud.navent.dao.CachedPedidosDao;
import com.facundolinlaud.navent.dto.PedidoDto;
import com.facundolinlaud.navent.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {
    @Autowired
    private CachedPedidosDao pedidosDao;

    public List<Pedido> getAllPedidos(){
        return pedidosDao.findAll();
    }

    public void delete(int id) {
        pedidosDao.delete(id);
    }

    public Pedido save(PedidoDto dto) {
        Pedido pedido = new Pedido(dto);
        return pedidosDao.save(pedido);
    }

    public Pedido update(PedidoDto dto){
        return save(dto);
    }
}
