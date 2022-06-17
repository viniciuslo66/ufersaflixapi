package com.ufersaflix.ufersaflixapi.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufersaflix.ufersaflixapi.model.entity.Usuario;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

  public LoginFilter(String url, AuthenticationManager authManager) {
    super((RequestMatcher) new AntPathMatcher(url));
    setAuthenticationManager(authManager);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {
    Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
    return getAuthenticationManager().authenticate(
        new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha(), Collections.emptyList()));
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authentication) throws IOException, ServletException {
    AuthenticationService.addToken(response, authentication.getName());
  }
}
