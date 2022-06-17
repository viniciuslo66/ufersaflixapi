package com.ufersaflix.ufersaflixapi.security;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
  static final long EXPIRATIONTIME = 864_000_00;
  static final String SIGNINGKEY = "SecretKey";
  static final String PREFIX = "Bearer";

  static public void addToken(HttpServletResponse response, String email) {
    String JwtToken = Jwts.builder().setSubject(email)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
        .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
        .compact();
    response.addHeader("Authorizarion", PREFIX + " " + JwtToken);
    response.addHeader("Access-Control-Expose-Headers", "Authorizarion");
  }

  static public Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    if (token != null) {
      String email = Jwts.parser()
          .setSigningKey(SIGNINGKEY)
          .parseClaimsJws(token.replace(PREFIX, ""))
          .getBody()
          .getSubject();
      if (email != null)
        return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
    }
    return null;
  }
}
