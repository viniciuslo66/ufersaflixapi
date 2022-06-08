package com.ufersaflix.ufersaflixapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufersaflix.ufersaflixapi.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
