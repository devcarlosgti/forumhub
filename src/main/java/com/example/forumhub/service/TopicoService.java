package com.example.forumhub.service;

import com.example.forumhub.dto.DadosCadastroTopico;
import com.example.forumhub.domain.topico.Topico;
import com.example.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public Topico cadastrar(DadosCadastroTopico dados) {

        Topico topico = new Topico();

        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());
        topico.setAutor(dados.autor());
        topico.setCurso(dados.curso());

        topico.setDataCriacao(LocalDateTime.now()); // ⭐ AQUI

        return repository.save(topico);
    }

    public List<Topico> listar() {
        return repository.findAll();
    }
}
