package br.com.alura.comex.builder;

import br.com.alura.comex.model.entities.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PedidoBuilder {

    public static Pedido getPedidoUnico() {
        Pedido pedidoUnico = new Pedido();
        pedidoUnico.setCategoria("CATEGORIA TESTE");
        pedidoUnico.setCliente("Cliente Teste");
        pedidoUnico.setData(LocalDate.of(2022, 2, 20));
        pedidoUnico.setPreco(BigDecimal.valueOf(100.50));
        pedidoUnico.setProduto("Produto Teste");
        pedidoUnico.setQuantidade(1);
        return pedidoUnico;
    }

    public static List<Pedido> getListaDePedidos() {

        Pedido pedidoUm = new Pedido();
        pedidoUm.setCategoria("CATEGORIA UM");
        pedidoUm.setCliente("Cliente um");
        pedidoUm.setData(LocalDate.of(2022, 3, 22));
        pedidoUm.setPreco(BigDecimal.valueOf(100.50));
        pedidoUm.setProduto("Produto um");
        pedidoUm.setQuantidade(1);

        Pedido pedidoDois = new Pedido();
        pedidoDois.setCategoria("CATEGORIA DOIS");
        pedidoDois.setCliente("Cliente um");
        pedidoDois.setData(LocalDate.of(2022, 3, 11));
        pedidoDois.setPreco(BigDecimal.valueOf(10.50));
        pedidoDois.setProduto("Produto dois");
        pedidoDois.setQuantidade(1);

        Pedido pedidoTres = new Pedido();
        pedidoTres.setCategoria("CATEGORIA TRES");
        pedidoTres.setCliente("Cliente um");
        pedidoTres.setData(LocalDate.of(2022, 5, 3));
        pedidoTres.setPreco(BigDecimal.valueOf(200.80));
        pedidoTres.setProduto("Produto três");
        pedidoTres.setQuantidade(1);

        return Arrays.asList(pedidoUm, pedidoDois, pedidoTres);
    }
}
