package br.com.alura.comex.builder;

import br.com.alura.comex.model.entities.Categoria;
import br.com.alura.comex.model.enums.Status;

public class CategoriaBuilder {

    private String nome;

    private Status status;

    public CategoriaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public CategoriaBuilder comStatus(Status status) {
        this.status = status;
        return this;
    }

    public Categoria build() {
        return new Categoria(nome, status);
    }

}
