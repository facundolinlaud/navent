package com.facundolinlaud.navent.controller;

import com.facundolinlaud.navent.dto.PedidoDto;
import com.facundolinlaud.navent.model.Pedido;
import com.facundolinlaud.navent.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosController {
    @Autowired
    private PedidosService pedidosService;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST,  consumes=MediaType.APPLICATION_JSON_VALUE)
    Pedido save(@RequestBody PedidoDto pedidoDto) {
        return pedidosService.save(pedidoDto);
    }
}
