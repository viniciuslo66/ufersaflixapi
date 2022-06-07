package com.ufersaflix.ufersaflixapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufersaflix.ufersaflixapi.model.entity.Usuario;
import com.ufersaflix.ufersaflixapi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  UsuarioService service;

  @GetMapping
  public List<Usuario> listar() {
    return service.listarUsuario();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Usuario salvarUsuario(@Valid @RequestBody Usuario usuario) {
    return service.saveUsuario(usuario);
  }
  
  /*
  @GetMapping("/{usuarioId}")
  public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId) {
    return repository.findById(usuarioId)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{usuarioId}")
  public ResponseEntity<Usuario> Atualizar(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {
    if (!repository.existsById(usuarioId)) {
      return ResponseEntity.notFound().build();
    }
    usuario = repository.save(usuario);
    return ResponseEntity.ok(usuario);
  }

  */
}
