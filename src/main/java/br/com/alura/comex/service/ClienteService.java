package br.com.alura.comex.service;

import br.com.alura.comex.model.entities.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listarTodos();

    Cliente listarPorCodigo(Long id);

    Cliente inserir(Cliente cliente);

    Cliente atualizar(Cliente cliente);

    void remover(Long id);
}
