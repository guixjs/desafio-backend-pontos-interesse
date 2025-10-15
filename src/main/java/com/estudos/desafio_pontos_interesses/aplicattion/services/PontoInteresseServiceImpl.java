package com.estudos.desafio_pontos_interesses.aplicattion.services;

import java.util.List;
import java.util.stream.Collectors;

import com.estudos.desafio_pontos_interesses.adapters.inbound.dtos.PontosInteresseDTO;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresse;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseRepository;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseService;
import com.estudos.desafio_pontos_interesses.domain.exceptions.CoordenadasDoPontoInvalidasException;

public class PontoInteresseServiceImpl implements PontoInteresseService {

  private final PontoInteresseRepository repository;

  public PontoInteresseServiceImpl(PontoInteresseRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<PontosInteresseDTO> listarTodosPontos() {
    List<PontosInteresseDTO> lista = repository.findAll()
        .stream().map(poi -> new PontosInteresseDTO(poi.getNome(), poi.getX(), poi.getY()))
        .toList();

    if (lista.isEmpty()) {
      System.out.println("lista vazia");
    } else {
      System.out.println("LISTA CHEIA");
    }
    return lista;
  }

  @Override
  public List<PontosInteresseDTO> pontosProximos(int x, int y, int distancia) {
    int xMin = x - distancia;
    int yMin = y - distancia;
    int xMax = x + distancia;
    int yMax = x + distancia;

    return repository.getPontosDentroDaArea(xMin, xMax, yMin, yMax)
        .stream().filter(poi -> calcularDistancia(x, y, poi, distancia) <= distancia)
        .map(poi2 -> new PontosInteresseDTO(poi2.getNome(), poi2.getX(), poi2.getY()))
        .collect(Collectors.toList());
  }

  private double calcularDistancia(int xAtual, int yAtual, PontoInteresse poi, int distancia) {
    int distanciaX = Math.abs(xAtual - poi.getX());
    int distanciaY = Math.abs(yAtual - poi.getY());

    double distanciaEntreOsPontos = Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
    return distanciaEntreOsPontos;

  }

  @Override
  public void cadastrarNovoPonto(PontosInteresseDTO dto) throws CoordenadasDoPontoInvalidasException {
    if (dto.x() < 0 || dto.y() < 0) {
      throw new CoordenadasDoPontoInvalidasException();
    }
    if (dto.name().isBlank()) {
      throw new CoordenadasDoPontoInvalidasException();
    }

    repository.save(dto);
  }

}
