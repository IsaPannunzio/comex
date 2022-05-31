package br.com.alura.comex.builder;

import br.com.alura.comex.model.entities.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoBuilder {

    public static Pedido getPrimeiroPedido() {
        Pedido primeiroPedido = new Pedido();
        primeiroPedido.setCategoria("CATEGORIA TESTE");
        primeiroPedido.setCliente("Cliente Teste");
        primeiroPedido.setData(LocalDate.of(2022, 2, 20));
        primeiroPedido.setPreco(BigDecimal.valueOf(100.50));
        primeiroPedido.setProduto("Produto Teste");
        primeiroPedido.setQuantidade(1);
        return primeiroPedido;
    }

    public static Pedido getSegundoPedido() {
        Pedido segundoPedido = new Pedido();
        segundoPedido.setCategoria("CATEGORIA TESTE DOIS");
        segundoPedido.setCliente("Cliente Teste Dois");
        segundoPedido.setData(LocalDate.of(2022, 3, 15));
        segundoPedido.setPreco(BigDecimal.valueOf(235.85));
        segundoPedido.setProduto("Produto Teste Dois");
        segundoPedido.setQuantidade(1);
        return segundoPedido;
    }

    public static Pedido getTerceiroPedido() {
        Pedido terceiroPedido = new Pedido();
        terceiroPedido.setCategoria("CATEGORIA TESTE TRÊS");
        terceiroPedido.setCliente("Cliente Teste Três");
        terceiroPedido.setData(LocalDate.of(2022, 5, 27));
        terceiroPedido.setPreco(BigDecimal.valueOf(312.00));
        terceiroPedido.setProduto("Produto Teste Três");
        terceiroPedido.setQuantidade(1);
        return terceiroPedido;
    }
}
