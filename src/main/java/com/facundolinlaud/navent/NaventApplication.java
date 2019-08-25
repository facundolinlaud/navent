package com.facundolinlaud.navent;

import com.facundolinlaud.navent.model.Pedido;
import com.facundolinlaud.navent.repository.PedidosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class NaventApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaventApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PedidosRepository repository){
		return args -> {
			repository.save(new Pedido("Pedido1", 50, 10));
			repository.save(new Pedido("Pedido2", 70, 20));
			repository.save(new Pedido("Pedido3", 20, 5));
		};
	}
}
