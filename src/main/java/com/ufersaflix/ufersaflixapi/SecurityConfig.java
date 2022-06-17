package com.ufersaflix.ufersaflixapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ufersaflix.ufersaflixapi.security.AuthorizationFilter;
import com.ufersaflix.ufersaflixapi.security.LoginFilter;
import com.ufersaflix.ufersaflixapi.service.impl.UsuarioDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UsuarioDetailsServiceImpl usuarioDetailsService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(usuarioDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().cors().and().authorizeRequests()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .antMatchers(HttpMethod.POST, "/usuarios").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new LoginFilter("/login", authenticationManager()),
            UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new AuthorizationFilter(),
            UsernamePasswordAuthenticationFilter.class);
  }
}
