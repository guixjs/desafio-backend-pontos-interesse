package com.estudos.desafio_pontos_interesses.domain;

import java.util.UUID;

public class PontoInteresse {

  private UUID id;
  private String nome;
  private int x;
  private int y;

  public PontoInteresse(UUID id, String nome, int x, int y) {
    this.id = id;
    this.nome = nome;
    this.x = x;
    this.y = y;
  }

  public PontoInteresse(String nome, int x, int y) {
    this.nome = nome;
    this.x = x;
    this.y = y;
  }

  public UUID getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}
