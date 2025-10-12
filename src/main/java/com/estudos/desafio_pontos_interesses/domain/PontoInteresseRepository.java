package com.estudos.desafio_pontos_interesses.domain;

import java.util.List;

public interface PontoInteresseRepository {

  List<PontoInteresse> findAll();

  List<PontoInteresse> getPontosDentroDaArea(int xMin, int xMax, int yMin, int yMax);

}
