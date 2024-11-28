package br.com.divertech.divertfest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class DivertfestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivertfestApplication.class, args);
	}
	
	@GetMapping
	public String testeHome() {
		return "Bem vindo ao Divertfest!";
	}
}