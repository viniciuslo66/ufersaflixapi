package com.ufersaflix.ufersaflixapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufersaflix.ufersaflixapi.model.entity.Usuario;
import com.ufersaflix.ufersaflixapi.model.repository.UsuarioRepository;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UsuarioRepository repository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario currentUsuario = repository.findUsuarioByEmail(email);
    UserDetails usuario = new org.springframework.security.core.userdetails.User(email, currentUsuario.getSenha(), true,
        true, true, true, AuthorityUtils
            .createAuthorityList("USER"));
    return usuario;
  }
}
