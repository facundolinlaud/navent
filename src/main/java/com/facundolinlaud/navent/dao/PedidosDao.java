package com.facundolinlaud.navent.dao;

import com.facundolinlaud.navent.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosDao extends JpaRepository<Pedido, Integer> {
    /* Si bien un DAO es algo más amplio que un repositorio, en este ejemplo, la interfaz del DAOes un subset de la
     interfaz provista por el JpaRepository de Spring. Me tomo la libertad de utilizar JpaRepository, donde viene todo
     regalado! */
}
