package br.com.alura.comex.service.impl;

import br.com.alura.comex.model.entities.Pedido;
import br.com.alura.comex.repository.PedidoRepository;
import br.com.alura.comex.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarTodos() {

        return pedidoRepository.findAll();
    }

    @Override
    public Pedido listarPorCodigo(Long id) {

        return pedidoRepository.findById(id).get();
    }

    @Override
    public Pedido inserir(Pedido pedido) {

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido atualizar(Pedido pedido) {

        return this.pedidoRepository.save(pedido);
    }

    @Override
    public void remover(Long id) {

        this.pedidoRepository.deleteById(id);
    }
}
