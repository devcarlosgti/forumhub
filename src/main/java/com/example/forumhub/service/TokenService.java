package com.example.forumhub.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class TokenService {

    private String secret = "123456";

    public String gerarToken(Authentication authentication){

        return JWT.create()
                .withIssuer("forumhub")
                .withSubject(authentication.getName())
                .withExpiresAt(Instant.now().plusSeconds(7200))
                .sign(Algorithm.HMAC256(secret));

    }

    public String validarToken(String token) {

        try {

            var algoritmo = com.auth0.jwt.algorithms.Algorithm.HMAC256(secret);

            return com.auth0.jwt.JWT
                    .require(algoritmo)
                    .withIssuer("forumhub")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (Exception e) {
            return null;
        }

    }
}