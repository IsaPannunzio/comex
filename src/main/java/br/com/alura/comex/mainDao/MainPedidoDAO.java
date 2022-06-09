package br.com.alura.comex.mainDao;

import br.com.alura.comex.dao.ClienteDAO;
import br.com.alura.comex.dao.PedidoDAO;
import br.com.alura.comex.dao.ProdutoDAO;
import br.com.alura.comex.model.entities.ItemDePedido;
import br.com.alura.comex.model.entities.Pedido;
import br.com.alura.comex.service.RelatorioPedidosPorCliente;
import br.com.alura.comex.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MainPedidoDAO {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        Pedido pedido = new Pedido(clienteDAO.buscarPorId(1L));
        pedido.adicionarItem(new ItemDePedido(1, produtoDAO.buscarPorId(1L), pedido));
        pedido.adicionarItem(new ItemDePedido(1, produtoDAO.buscarPorId(2L), pedido));
        pedido.adicionarItem(new ItemDePedido( 2, produtoDAO.buscarPorId(5L), pedido));

        pedidoDAO.cadastrar(pedido);
        em.getTransaction().commit();

        List<RelatorioPedidosPorCliente> relatorio = pedidoDAO.pedidosPorCliente();
        relatorio.forEach(System.out::println);


    }
}
