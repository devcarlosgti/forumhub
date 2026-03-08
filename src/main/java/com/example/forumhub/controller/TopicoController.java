package com.example.forumhub.controller;

import com.example.forumhub.domain.topico.DadosDetalhamentoTopico;
import com.example.forumhub.dto.DadosAtualizacaoTopico;
import com.example.forumhub.dto.DadosCadastroTopico;
import com.example.forumhub.dto.DadosListagemTopico;
import com.example.forumhub.domain.topico.Topico;
import com.example.forumhub.repository.TopicoRepository;
import com.example.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        var topico = service.cadastrar(dados);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public List<DadosListagemTopico> listar() {
        return repository.findAll()
                .stream()
                .map(DadosListagemTopico::new)
                .toList();
    }

    @GetMapping("/{id}")
    public Topico buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id,
                                    @RequestBody DadosAtualizacaoTopico dados) {

        var topico = repository.getReferenceById(id);

        if (dados.titulo() != null) {
            topico.setTitulo(dados.titulo());
        }

        if (dados.mensagem() != null) {
            topico.setMensagem(dados.mensagem());
        }

        if (dados.autor() != null) {
            topico.setAutor(dados.autor());
        }

        if (dados.curso() != null) {
            topico.setCurso(dados.curso());
        }

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
