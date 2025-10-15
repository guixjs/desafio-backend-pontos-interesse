package com.estudos.desafio_pontos_interesses.domain.exceptions;

public class CoordenadasDoPontoInvalidasException extends Exception {

  public CoordenadasDoPontoInvalidasException() {
    super("As coordenadas devem ser maiores que 0");
  }
}
