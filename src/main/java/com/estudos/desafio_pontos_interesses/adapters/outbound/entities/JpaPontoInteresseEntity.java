package com.estudos.desafio_pontos_interesses.adapters.outbound.entities;

import java.util.UUID;

import com.estudos.desafio_pontos_interesses.domain.PontoInteresse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ponto_interesse_tb")

public class JpaPontoInteresseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String nome;
  private int x;
  private int y;

  public JpaPontoInteresseEntity(PontoInteresse pontoInteresse) {
    this.id = pontoInteresse.getId();
    this.nome = pontoInteresse.getNome();
    this.x = pontoInteresse.getX();
    this.y = pontoInteresse.getY();
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
