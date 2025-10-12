package com.estudos.desafio_pontos_interesses.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.estudos.desafio_pontos_interesses.aplicattion.services.PontoInteresseServiceImpl;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseService;

@Configuration
public class BeanConfig {

  @Bean
  public PontoInteresseService pontoInteresseService() {
    return new PontoInteresseServiceImpl();
  }

}
