package com.example.forumhub.controller;

import com.example.forumhub.domain.topico.DadosCadastroTopico;
import com.example.forumhub.domain.topico.Topico;
import com.example.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroTopico dados) {

        Topico topico = new Topico(
                dados.titulo(),
                dados.mensagem(),
                dados.autor(),
                dados.curso()
        );

        repository.save(topico);
    }

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Topico buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Topico atualizar(@PathVariable Long id, @RequestBody Topico dados) {

        Topico topico = repository.findById(id).orElseThrow();

        topico.setTitulo(dados.getTitulo());
        topico.setMensagem(dados.getMensagem());
        topico.setAutor(dados.getAutor());
        topico.setCurso(dados.getCurso());

        return repository.save(topico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
