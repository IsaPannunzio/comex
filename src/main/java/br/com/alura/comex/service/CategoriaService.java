package br.com.alura.comex.service;

import br.com.alura.comex.model.entities.Categoria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listarTodos();

    public Page<Categoria> obterPagina(Integer page, Integer linhasPorPage, String ordenarPor, String direcao);

    Categoria listarPorCodigo(Long id);

    Categoria inserir(Categoria categoria);

    Categoria atualizar(Categoria categoria);

    Categoria alterarStatus(Categoria categoria);

    void remover(Long id);

}
