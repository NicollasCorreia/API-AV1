package com.projeto.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
public class Categoria {
    @Id @GeneratedValue
    private Long id;

    @NotNull(message = "Nome da categoria é obrigatório")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
