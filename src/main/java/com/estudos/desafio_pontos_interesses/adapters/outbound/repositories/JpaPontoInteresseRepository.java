package com.estudos.desafio_pontos_interesses.adapters.outbound.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.estudos.desafio_pontos_interesses.adapters.outbound.entities.JpaPontoInteresseEntity;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresse;

public interface JpaPontoInteresseRepository extends JpaRepository<JpaPontoInteresseEntity, UUID> {

  @Query("""
      SELECT p FROM JpaPontoInteresseEntity p
      WHERE (p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax)
      """)
  List<PontoInteresse> getPontosDentroDaArea(
      @Param(value = "xMin") int xMin,
      @Param(value = "xMax") int xMax,
      @Param(value = "yMin") int yMin,
      @Param(value = "yMax") int yMax);
}
