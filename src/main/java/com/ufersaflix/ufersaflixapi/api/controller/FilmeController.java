package com.ufersaflix.ufersaflixapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufersaflix.ufersaflixapi.model.entity.Filme;
import com.ufersaflix.ufersaflixapi.service.FilmeService;


@RestController
@RequestMapping("/filme")
public class FilmeController {

  @Autowired
  private FilmeService service;

  @GetMapping
  public ResponseEntity<List<Filme>> listarFilmes() {
    return ResponseEntity.ok().body(service.listarFilme());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Filme> findById(@PathVariable Long id) {
    Filme filme = service.findById(id);
    return ResponseEntity.ok().body(filme);
  }

  @PostMapping
  public ResponseEntity<Filme> salvarFilme(@RequestBody @Valid Filme filme) {
      Filme dto = service.salvarFilme(filme);
      return ResponseEntity.ok().body(dto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody @Valid Filme filme) {
    Filme dto = service.update(id, filme);
    return ResponseEntity.ok().body(dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
    service.deleteFilme(id);
    return ResponseEntity.noContent().build();
  }
}
