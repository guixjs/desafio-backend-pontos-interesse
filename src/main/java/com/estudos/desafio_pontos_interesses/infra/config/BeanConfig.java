package com.estudos.desafio_pontos_interesses.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.estudos.desafio_pontos_interesses.adapters.outbound.repositories.JpaPontoInteresseRepository;
import com.estudos.desafio_pontos_interesses.adapters.outbound.repositories.PontoInteresseRepositoryImpl;
import com.estudos.desafio_pontos_interesses.aplicattion.services.PontoInteresseServiceImpl;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseRepository;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseService;

@Configuration
public class BeanConfig {

  @Bean
  PontoInteresseRepository pontoInteresseRepository(JpaPontoInteresseRepository repository){
    return new PontoInteresseRepositoryImpl(repository);
  }

  @Bean
  PontoInteresseService pontoInteresseService(PontoInteresseRepository repository) {
    return new PontoInteresseServiceImpl(repository);
  }

}
