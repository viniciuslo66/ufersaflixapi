package com.ufersaflix.ufersaflixapi.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufersaflix.ufersaflixapi.model.entity.Filme;
import com.ufersaflix.ufersaflixapi.model.repository.FilmeRepository;



@Service
public class FilmeService {
  @Autowired

  FilmeRepository repository;

  public FilmeService(FilmeRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public Filme salvarFilme(Filme filme) {
    return repository.save(filme);
  }


  public List<Filme> listarFilme() {
    return repository.findAll();
  }

  @Transactional
  public Filme update(Long id, Filme dto) {
    Optional<Filme> fOptional = repository.findById(id);
    Filme filme = fOptional.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));

    filme.converte(dto);

    return repository.save(filme);
  }

  @Transactional(readOnly = true)
  public Filme findById(Long id) {
    Optional<Filme> fOptional = repository.findById(id);
    Filme filme = fOptional.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
    return filme;
  }

  @Transactional
  public void deleteFilme(Long id) {
    Optional<Filme> fOptional = repository.findById(id);
    Filme filme =  fOptional.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
    repository.delete(filme);
  }
}
