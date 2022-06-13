package br.com.alura.comex.service;

import br.com.alura.comex.model.entities.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> listarTodos();

    Pedido listarPorCodigo(Long id);

    Pedido inserir(Pedido pedido);

    Pedido atualizar(Pedido pedido);

    void remover(Long id);
}
