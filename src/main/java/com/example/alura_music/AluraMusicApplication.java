package com.example.alura_music;

import com.example.alura_music.principal.Principal;
import com.example.alura_music.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicApplication implements CommandLineRunner {
	@Autowired
	ArtistaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(AluraMusicApplication.class, args);
	}

	@java.lang.Override
	public void run(java.lang.String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibirMenu();
	}
}
