package com.example.forumhub.controller;

import com.example.forumhub.domain.Topico;
import com.example.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }
}
