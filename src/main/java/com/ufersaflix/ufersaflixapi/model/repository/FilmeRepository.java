package com.ufersaflix.ufersaflixapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufersaflix.ufersaflixapi.model.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
