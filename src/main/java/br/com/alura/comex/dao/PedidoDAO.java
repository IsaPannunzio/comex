package br.com.alura.comex.dao;

import br.com.alura.comex.model.entities.Pedido;
import br.com.alura.comex.service.RelatorioPedidosPorCliente;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDAO {

    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return em.find(Pedido.class, id);
    }

    public List<RelatorioPedidosPorCliente> pedidosPorCliente() {
        String jpql = "SELECT new br.com.alura.comex.vo.RelatorioPedidosPorClienteVo(pedido.cliente.nome, COUNT(pedido.cliente))" +
                "FROM Pedido pedido " +
                "JOIN pedido.itens item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.categoria.nome ";
        return em.createQuery(jpql, RelatorioPedidosPorCliente.class).getResultList();
    }
}
