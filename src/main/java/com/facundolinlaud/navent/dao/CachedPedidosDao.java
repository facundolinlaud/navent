package com.facundolinlaud.navent.dao;

import com.facundolinlaud.navent.cache.BumexMemcached;
import com.facundolinlaud.navent.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CachedPedidosDao {
    private static final boolean DEBUG = true;

    @Autowired
    private BumexMemcached memcached;

    @Autowired
    private PedidosDao pedidosDao;

    public List<Pedido> findAll(){
        return pedidosDao.findAll();
    }

    public Pedido save(Pedido pedido) {
        String key = String.valueOf(pedido.getIdPedido());
        memcached.set(key, pedido);

        if(DEBUG)
            return pedidosDao.save(pedido);

        return pedido;
    }

    public Optional<Pedido> findById(int id) {
        String key = String.valueOf(id);

        if(memcached.has(key))
            return Optional.of((Pedido) memcached.get(key));

        return pedidosDao.findById(id);
    }

    public void delete(int id) {
        String key = String.valueOf(id);
        memcached.delete(key);

        if(DEBUG) pedidosDao.deleteById(id);
    }
}
