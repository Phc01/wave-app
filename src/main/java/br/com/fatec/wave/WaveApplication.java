package br.com.fatec.wave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaveApplication {

	public static void main(String[] args) {
		// Bloco de Debug para Variáveis de Ambiente no Render
		System.out.println("==========================================================");
		System.out.println("INICIANDO DEBUG DE VARIÁVEIS DE AMBIENTE NO RENDER (main)");
		System.out.println("SPRING_PROFILES_ACTIVE: " + System.getenv("SPRING_PROFILES_ACTIVE"));
		System.out.println("SPRING_DATASOURCE_JDBC_URL: " + System.getenv("SPRING_DATASOURCE_JDBC_URL"));
		System.out.println("SPRING_DATASOURCE_USERNAME: " + System.getenv("SPRING_DATASOURCE_USERNAME"));
		String password = System.getenv("SPRING_DATASOURCE_PASSWORD");
		System.out.println("SPRING_DATASOURCE_PASSWORD is present: " + (password != null && !password.isEmpty()));
		System.out.println("==========================================================");

		SpringApplication.run(WaveApplication.class, args);
	}

}
