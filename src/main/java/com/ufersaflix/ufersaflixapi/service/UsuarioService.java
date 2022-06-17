package com.ufersaflix.ufersaflixapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufersaflix.ufersaflixapi.api.dto.UsuarioDto;
import com.ufersaflix.ufersaflixapi.model.entity.Usuario;
import com.ufersaflix.ufersaflixapi.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  UsuarioRepository repository;

  @Autowired
  private ModelMapper mapper;


  public UsuarioService(UsuarioRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public UsuarioDto saveUsuario(Usuario usuario) {
    return mapper.map(repository.save(usuario), UsuarioDto.class);
  }

  @Transactional
  public Usuario update(Long id, Usuario dto) {
    Optional<Usuario> uOptional = repository.findById(id);
    Usuario usuario = uOptional.orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));

    usuario.converte(dto);

    return repository.save(usuario);
  }
  
  public List<UsuarioDto> listarUsuario() {
    List<UsuarioDto> list = new ArrayList<UsuarioDto>();
    for (Usuario usuario : repository.findAll()) {
      list.add(mapper.map(usuario, UsuarioDto.class));
    }
    return list;
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
