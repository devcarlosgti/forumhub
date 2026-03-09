package com.example.forumhub.controller;

import com.example.forumhub.dto.DadosAutenticacaoUsuario;

import com.example.forumhub.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody DadosAutenticacaoUsuario dados){

        var authenticationToken =
                new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var authentication = manager.authenticate(authenticationToken);

        return tokenService.gerarToken(authentication);

    }
}
