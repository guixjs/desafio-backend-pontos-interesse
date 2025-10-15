package com.estudos.desafio_pontos_interesses.domain;

import java.util.List;

import com.estudos.desafio_pontos_interesses.adapters.inbound.dtos.PontosInteresseDTO;

public interface PontoInteresseRepository {

  void save(PontosInteresseDTO dto);

  List<PontoInteresse> findAll();

  List<PontoInteresse> getPontosDentroDaArea(int xMin, int xMax, int yMin, int yMax);

}
