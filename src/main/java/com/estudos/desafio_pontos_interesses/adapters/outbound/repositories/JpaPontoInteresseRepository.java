package com.estudos.desafio_pontos_interesses.adapters.outbound.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.desafio_pontos_interesses.adapters.outbound.entities.JpaPontoInteresseEntity;

public interface JpaPontoInteresseRepository extends JpaRepository<JpaPontoInteresseEntity, UUID> {

}
