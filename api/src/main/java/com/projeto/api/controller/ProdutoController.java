package com.projeto.api.controller;

import com.projeto.api.dto.ProdutoDTO;
import com.projeto.api.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoDTO> listarTodos() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody @Valid ProdutoDTO produtoDTO) {
        ProdutoDTO produtoCriado = produtoService.criar(produtoDTO);
        URI location = URI.create("/produtos/" + produtoCriado.getId());
        return ResponseEntity.created(location).build();
    }
}
