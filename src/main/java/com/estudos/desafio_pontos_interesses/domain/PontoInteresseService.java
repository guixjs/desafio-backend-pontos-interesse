package com.estudos.desafio_pontos_interesses.domain;

import java.util.List;

import com.estudos.desafio_pontos_interesses.adapters.inbound.dtos.PontosInteresseDTO;
import com.estudos.desafio_pontos_interesses.domain.exceptions.CoordenadasDoPontoInvalidasException;

public interface PontoInteresseService {
  List<PontosInteresseDTO> listarTodosPontos();

  List<PontosInteresseDTO> pontosProximos(int x, int y, int distancia);

  void cadastrarNovoPonto(PontosInteresseDTO dto) throws CoordenadasDoPontoInvalidasException;
}
