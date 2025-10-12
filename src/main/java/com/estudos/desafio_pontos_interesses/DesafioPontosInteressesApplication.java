package com.estudos.desafio_pontos_interesses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estudos.desafio_pontos_interesses.adapters.outbound.entities.JpaPontoInteresseEntity;
import com.estudos.desafio_pontos_interesses.adapters.outbound.repositories.JpaPontoInteresseRepository;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresse;

@SpringBootApplication
public class DesafioPontosInteressesApplication implements CommandLineRunner {

	@Autowired
	private JpaPontoInteresseRepository jpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioPontosInteressesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jpaRepository.save(new JpaPontoInteresseEntity(new PontoInteresse("Lanchonete", 27, 12)));
		jpaRepository.save(new JpaPontoInteresseEntity(new PontoInteresse("Posto", 31, 18)));
		jpaRepository.save(new JpaPontoInteresseEntity(new PontoInteresse("Joalheria", 15, 12)));
		jpaRepository.save(new JpaPontoInteresseEntity(new PontoInteresse("Floricultura", 19, 21)));
		jpaRepository.save(new JpaPontoInteresseEntity(new PontoInteresse("Pub", 12, 8)));
		jpaRepository.save(new JpaPontoInteresseEntity(new PontoInteresse("Supermercado", 26, 3)));
		jpaRepository.save(new JpaPontoInteresseEntity(new PontoInteresse("Churrascaria", 28, 2)));
	}

}
