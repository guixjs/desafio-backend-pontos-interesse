package com.estudos.desafio_pontos_interesses.adapters.outbound.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.estudos.desafio_pontos_interesses.domain.PontoInteresse;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseRepository;

public class PontoInteresseRepositoryImpl implements PontoInteresseRepository {

  private final JpaPontoInteresseRepository jpaRepository;

  PontoInteresseRepositoryImpl(JpaPontoInteresseRepository jpa) {
    this.jpaRepository = jpa;
  }

  @Override
  public List<PontoInteresse> findAll() {
    return this.jpaRepository.findAll()
        .stream().map(poi -> new PontoInteresse(poi.getId(), poi.getNome(), poi.getX(), poi.getY()))
        .collect(Collectors.toList());
  }

  @Override
  public List<PontoInteresse> getPontosDentroDaArea(int xMin, int xMax, int yMin, int yMax) {
    return jpaRepository.getPontosDentroDaArea(xMin, xMax, yMin, yMax)
        .stream().map(poi -> new PontoInteresse(poi.getId(), poi.getNome(), poi.getX(), poi.getY()))
        .collect(Collectors.toList());
  }

}
