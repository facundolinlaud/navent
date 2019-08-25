package com.facundolinlaud.navent;

import com.facundolinlaud.navent.dao.PedidosDao;
import com.facundolinlaud.navent.dto.PedidoDto;
import com.facundolinlaud.navent.model.Pedido;
import com.facundolinlaud.navent.service.PedidosService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidosServiceTest {
    @Autowired
    private PedidosDao pedidosDao;

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
    public void setUp() {
        pedidosDao.deleteAll();
        pedidos.forEach(dto -> pedidosDao.save(new Pedido(dto)));
    }

    @Test
    public void getAllPedidosShouldReturnAllPedidos() {
        List<Pedido> result = pedidosService.getAllPedidos();

        Assert.assertEquals(pedidos.size(), result.size());
    }

    /* Debería ser ConstraintViolationException pero hibernate la wrappea en TransactionSystemException. Tiene solución
       pero involucra mucha manopla. La idea se entiende! */
    @Test(expected = TransactionSystemException.class)
    public void addPedidoWithLongNameShouldThrowException() {
        StringBuilder stringBuilder = new StringBuilder(206);

        for(int i = 0; i < 205; i++) {
            stringBuilder.append("a");
        }

        PedidoDto dto = new PedidoDto(stringBuilder.toString(), 10, 10);

        pedidosService.save(dto);
    }

    @Test
    public void deletePedidoShouldDeletePedido() {
        Pedido newPedido = pedidosService.save(new PedidoDto("nombre", 5, 5));

        List<Pedido> result = pedidosService.getAllPedidos();
        Assert.assertEquals(pedidos.size() + 1, result.size());

        pedidosService.delete(newPedido.getIdPedido());
        result = pedidosService.getAllPedidos();
        Assert.assertEquals(pedidos.size(), result.size());
    }
}
