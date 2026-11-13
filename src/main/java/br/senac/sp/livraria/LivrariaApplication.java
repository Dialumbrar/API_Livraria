package br.senac.sp.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Configura esta classe como a inicializadora do Spring Boot
public class LivrariaApplication {

	// O modificador 'public' foi removido aqui por ser redundante nesta versão do Java
	static void main(String[] args) {

		SpringApplication.run(LivrariaApplication.class, args);
	}

}
