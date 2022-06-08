package com.ufersaflix.ufersaflixapi.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufersaflix.ufersaflixapi.model.entity.Usuario;
import com.ufersaflix.ufersaflixapi.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  UsuarioRepository repository;

  public UsuarioService(UsuarioRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public Usuario saveUsuario(Usuario usuario) {
    return repository.save(usuario);
  }

  @Transactional
  public Usuario update(Long id, Usuario dto) {
    Optional<Usuario> uOptional = repository.findById(id);
    Usuario usuario = uOptional.orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));

    usuario.converte(dto);

    return repository.save(usuario);
  }
  
  public List<Usuario> listarUsuario() {
    return repository.findAll();
  }

  @Transactional(readOnly = true)
  public Usuario findById(Long id) {
    Optional<Usuario> usuarioOpt = repository.findById(id);
    Usuario usuario = usuarioOpt.orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
    return usuario;
  }

  @Transactional
  public void deleteUsuario(Long id) {
    Optional<Usuario> usuarioOpt = repository.findById(id);
    Usuario usuario = usuarioOpt.orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));

    repository.delete(usuario);
  }
}
