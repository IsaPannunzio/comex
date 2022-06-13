package br.com.alura.comex.service;

import br.com.alura.comex.model.entities.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listarTodos();

    Categoria listarPorCodigo(Long id);

    Categoria inserir(Categoria categoria);

    Categoria atualizar(Categoria categoria);

    void remover(Long id);

}
