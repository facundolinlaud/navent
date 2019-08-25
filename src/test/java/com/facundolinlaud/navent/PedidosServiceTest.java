package com.facundolinlaud.navent;

import com.facundolinlaud.navent.dto.PedidoDto;
import com.facundolinlaud.navent.model.Pedido;
import com.facundolinlaud.navent.repository.PedidosRepository;
import com.facundolinlaud.navent.service.PedidosService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidosServiceTest {
    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private PedidosService pedidosService;

    private List<PedidoDto> pedidos;

    public PedidosServiceTest() {
        this.pedidos = Arrays.asList(
            new PedidoDto("PedidoTest1", 50, 10),
            new PedidoDto("PedidoTest2", 70, 20),
            new PedidoDto("PedidoTest3", 20, 5)
        );
    }

    @Before
    public void setUp() throws Exception {
        pedidosRepository.deleteAll();
        pedidos.forEach(dto -> pedidosRepository.save(new Pedido(dto)));
    }

    @Test
    public void getAllPedidosShouldReturnAllPedidos() {
        List<Pedido> result = pedidosService.getAllPedidos();

        Assert.assertEquals(pedidos.size(), result.size());
    }

    @Test
    public void deletePedidoShouldDeletePedido() {
        PedidoDto pedido = pedidos.get(0);

        pedidosService.delete(pedido);
        List<Pedido> result = pedidosService.getAllPedidos();

        Assert.assertEquals(pedidos.size() - 1, result.size());
    }
}
