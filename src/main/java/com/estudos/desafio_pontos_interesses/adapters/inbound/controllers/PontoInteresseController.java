package com.estudos.desafio_pontos_interesses.adapters.inbound.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.desafio_pontos_interesses.adapters.inbound.dtos.PontosInteresseDTO;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseService;
import com.estudos.desafio_pontos_interesses.domain.exceptions.CoordenadasDoPontoInvalidasException;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("points")
public class PontoInteresseController {

  private final PontoInteresseService pontoInteresseService;

  public PontoInteresseController(PontoInteresseService pontoInteresseService) {
    this.pontoInteresseService = pontoInteresseService;
  }

  @GetMapping("/alls")
  public ResponseEntity<List<PontosInteresseDTO>> getAllsPoints() {

    try {
      List<PontosInteresseDTO> points = pontoInteresseService.listarTodosPontos();
      return ResponseEntity.ok().body(points);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }

  }

  @PostMapping("/new")
  public ResponseEntity<String> createPoint(@RequestBody PontosInteresseDTO dto) {

    try {
      pontoInteresseService.cadastrarNovoPonto(dto);
      return ResponseEntity.ok().body("O ponto foi criado");
    } catch (CoordenadasDoPontoInvalidasException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.badRequest().body("O ponto não foi criado");

    }
  }

  @GetMapping("/near")
  public ResponseEntity<List<PontosInteresseDTO>> getPointsNear(@RequestParam int x, @RequestParam int y,
      @RequestParam int distancia) {
    try {
      List<PontosInteresseDTO> pontos = pontoInteresseService.pontosProximos(x, y, distancia);
      return ResponseEntity.ok().body(pontos);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }

  }

}
