package br.senac.sp.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Configura esta classe como a inicializadora do Spring Boot
public class LivrariaApplication {

	// JAVA 25: O modificador 'public' foi removido aqui por ser redundante nesta versão do Java
	static void main(String[] args) {
		// Inicializa o servidor embutido e carrega o ecossistema do Spring
		SpringApplication.run(LivrariaApplication.class, args);
	}

}
