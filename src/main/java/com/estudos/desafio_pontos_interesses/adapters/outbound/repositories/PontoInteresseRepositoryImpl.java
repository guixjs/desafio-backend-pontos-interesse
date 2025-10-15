package com.estudos.desafio_pontos_interesses.adapters.outbound.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.estudos.desafio_pontos_interesses.adapters.inbound.dtos.PontosInteresseDTO;
import com.estudos.desafio_pontos_interesses.adapters.outbound.entities.JpaPontoInteresseEntity;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresse;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseRepository;

public class PontoInteresseRepositoryImpl implements PontoInteresseRepository {

  private final JpaPontoInteresseRepository jpaRepository;

  public PontoInteresseRepositoryImpl(JpaPontoInteresseRepository jpa) {
    System.out.println("REPOSITORIO INSTANCIADO");
    this.jpaRepository = jpa;
  }

  @Override
  public List<PontoInteresse> findAll() {
    System.out.println("Chamou findAll do repository!");
    List<PontoInteresse> pontos = this.jpaRepository.findAll()
        .stream().map(poi -> new PontoInteresse(poi.getId(), poi.getNome(), poi.getX(), poi.getY()))
        .collect(Collectors.toList());
    System.out.println("Tamanho da lista: " + (pontos == null ? "null" : pontos.size()));
    return pontos;
  }

  @Override
  public List<PontoInteresse> getPontosDentroDaArea(int xMin, int xMax, int yMin, int yMax) {
    return jpaRepository.getPontosDentroDaArea(xMin, xMax, yMin, yMax)
        .stream().map(poi -> new PontoInteresse(poi.getId(), poi.getNome(), poi.getX(), poi.getY()))
        .collect(Collectors.toList());
  }

  @Override
  public void save(PontosInteresseDTO dto) {
    JpaPontoInteresseEntity poi = new JpaPontoInteresseEntity(new PontoInteresse(dto.name(), dto.x(), dto.y()));

    jpaRepository.save(poi);
    System.out.println("Cadastrada");
  }

}
