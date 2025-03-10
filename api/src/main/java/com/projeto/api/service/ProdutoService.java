package com.projeto.api.service;

import com.projeto.api.dto.ProdutoDTO;
import com.projeto.api.model.Produto;
import com.projeto.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(produto -> new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco()))
                .collect(Collectors.toList());
    }

    public ProdutoDTO criar(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto = repository.save(produto);
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco());
    }
}
