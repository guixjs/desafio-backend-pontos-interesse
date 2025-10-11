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

  PontoInteresseController(PontoInteresseService pontoInteresseService) {
    this.pontoInteresseService = pontoInteresseService;
  }

  @GetMapping("/alls")
  public ResponseEntity<List<PontosInteresseDTO>> getAllsPoints(@RequestParam String param) {

    try {
      List<PontosInteresseDTO> points = pontoInteresseService.listarTodosPontos();
      return ResponseEntity.ok().body(points);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

  }

}
