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

@Entity
@Table(name = "usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  UUID uuid;
  String nome;

  @Column(unique = true)
  @NotBlank(message = "Email não pode ser nulo")
  @Email(message = "O Email deve ser válido")
  String email;

  @NotBlank(message = "Uma senha precisa ser definida")
  @Size(min = 6, max = 20, message = "A senha deve está entre 6 e 20 caracteres")
  String senha;

  boolean adm;

  public Usuario() {
    uuid = UUID.randomUUID();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean isAdm() {
    return adm;
  }

  public void setAdm(boolean adm) {
    this.adm = adm;
  }

}
