package com.ufersaflix.ufersaflixapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufersaflix.ufersaflixapi.model.entity.Usuario;
import com.ufersaflix.ufersaflixapi.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
  @Autowired
  UsuarioRepository repository;

  public Usuario saveUsuario(Usuario usuario) {
    return repository.save(usuario);
  }

  public List<Usuario> listarUsuario() {
    return repository.findAll();
  }
}
