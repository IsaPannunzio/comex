package br.com.alura.comex.repository;

import br.com.alura.comex.model.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PedidoRepositoryTest {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private ItemDePedidoRepository itemDePedidoRepository;

  @Test
  void deveGerarRelatorioDePedidosPorCategoria() {


    Categoria livros =  new Categoria("JOGOS");
    Categoria carros =  new Categoria("LIVROS");

    List<Categoria> categorias = List.of(livros, carros);


    Produto produto1 = new Produto("Skyrim",
            "Quinto livro do saga The Elder Scrolls",
            new BigDecimal("160"),
            100,
            categorias.get(0));
    Produto produto2 = new Produto("Honda Fit",
            "Autobiogafia",
            new BigDecimal("50"),
            50,
            categorias.get(1));

    List<Produto> produtos = List.of(produto1, produto2);


    List<Perfil> perfil = new ArrayList<>();

    Pedido pedido1 = new Pedido();
    Pedido pedido2 = new Pedido();

    List<Pedido> pedidos = List.of(pedido1, pedido2);

    ItemDePedido itemPedido1 = new ItemDePedido();
    ItemDePedido itemPedido2 = new ItemDePedido();

    List<ItemDePedido> itensDePedidos = List.of(itemPedido1, itemPedido2);

    pedidoRepository.saveAll(pedidos);
    List<Pedido> pedidoList = pedidoRepository.findAll();

    assertNotNull(pedidoList);
  }
}