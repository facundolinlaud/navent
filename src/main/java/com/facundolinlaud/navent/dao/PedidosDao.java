package com.facundolinlaud.navent.dao;

import com.facundolinlaud.navent.model.Pedido;
import com.facundolinlaud.navent.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PedidosDao implements BaseDAO<Pedido> {
    /* Si bien un DAO es algo más amplio que un repositorio, la interfaz de este ejemplo es un subset de la interfaz
       provista por el JpaRepository de Spring */

    @Autowired
    private PedidosRepository pedidosRepository;

    @Override
    public void insertOrUpdate(Pedido pedido) {
        pedidosRepository.save(pedido);
    }

    @Override
    public void delete(Pedido pedido) {
        pedidosRepository.delete(pedido);
    }

    @Override
    public Pedido select(int id) {
        return pedidosRepository.findById((long) id).orElse(null);
    }
}
