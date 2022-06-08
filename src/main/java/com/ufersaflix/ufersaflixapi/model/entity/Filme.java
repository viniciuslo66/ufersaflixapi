package com.ufersaflix.ufersaflixapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "filme")
public class Filme {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  @NotBlank(message = "Insira um titulo válido")
  private String titulo;

  @NotBlank(message = "Insira uma URL válida")
  private String urlimage;

  @NotBlank(message = "Insira uma URL válida")
  private String urlfilme;

  @NotBlank(message = "Insira uma elenco válido")
  private String elenco;

  @NotBlank(message = "Insira uma sinopse válida")
  private String sinopse;

  @NotBlank(message = "Insira um gênero válido")
  private String genero;

  @NotBlank(message = "Insira um nome válido")
  private String diretor;

  public void converte(Filme dto) {
    setTitulo(dto.titulo);
    setUrlimage(dto.urlimage);
    setUrlfilme(dto.urlfilme);
    setElenco(dto.elenco);
    setSinopse(dto.sinopse);
    setGenero(dto.genero);
    setDiretor(dto.diretor);
  }
}
