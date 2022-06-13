package br.com.alura.comex.service;

import br.com.alura.comex.model.entities.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> listarTodos();

    Produto listarPorCodigo(Long id);

    Produto inserir(Produto produto);

    Produto atualizar(Produto produto);

    void remover(Long id);
}
