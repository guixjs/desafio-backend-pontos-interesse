package com.estudos.desafio_pontos_interesses.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.desafio_pontos_interesses.adapters.inbound.dtos.PontosInteresseDTO;
import com.estudos.desafio_pontos_interesses.domain.PontoInteresseService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("points")
public class PontoInteresseController {

  private final PontoInteresseService pontoInteresseService;

  public PontoInteresseController(PontoInteresseService pontoInteresseService) {
    System.out.println("Controller intanciado");
    this.pontoInteresseService = pontoInteresseService;
  }

  @GetMapping("/alls")
  public ResponseEntity<List<PontosInteresseDTO>> getAllsPoints() {

    try {
      List<PontosInteresseDTO> points = pontoInteresseService.listarTodosPontos();
      System.out.println("TESTANDO FUNCIONOU");
      return ResponseEntity.ok().body(points);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("TESTANDO NAO FUNCIONOU");
      return ResponseEntity.badRequest().build();
    }

  }

}
