package com.ufersaflix.ufersaflixapi.api.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class UsuarioDto {
  private String email;
  private UUID uuid;
}
