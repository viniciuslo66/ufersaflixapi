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

import com.ufersaflix.ufersaflixapi.model.entity.Usuario;
import com.ufersaflix.ufersaflixapi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioService service;

  @GetMapping
  public ResponseEntity<List<Usuario>> listarUsuario() {
    return ResponseEntity.ok().body(service.listarUsuario());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> findById(@PathVariable Long id) {
    Usuario usuario = service.findById(id);
    return ResponseEntity.ok().body(usuario);
  }

  @PostMapping
  public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario) {
    Usuario dto = service.saveUsuario(usuario);
    return ResponseEntity.ok().body(dto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
    Usuario usuarioDTO = service.update(id, usuario);
    return ResponseEntity.ok().body(usuarioDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
    service.deleteUsuario(id);
    return ResponseEntity.noContent().build();
  }

}
