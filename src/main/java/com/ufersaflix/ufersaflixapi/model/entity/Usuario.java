package com.ufersaflix.ufersaflixapi.model.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private UUID uuid;

  @NotBlank(message = "Insira um nome de usuário válido")
  private String nome;

  @Column(unique = true)
  @NotBlank
  @Email(message = "Insira um email válido")
  private String email;

  @NotBlank
  @Size(min = 6, max = 20, message = "A senha tem que ter de 6 a 20 caracteres")
  private String senha;

  private boolean adm;

  public Usuario() {
    uuid = UUID.randomUUID();
  }

  public void converte(Usuario dto) {
    setNome(dto.getNome());
    setEmail(dto.getEmail());
    setSenha(dto.getSenha());
    setAdm(dto.isAdm());
  }
}
