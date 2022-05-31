package br.com.alura.comex.builder;

import br.com.alura.comex.model.entities.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoBuilder {

    public static Pedido getPedido() {
        Pedido primeiroPedido = new Pedido();
        primeiroPedido.setCategoria("CATEGORIA TESTE");
        primeiroPedido.setCliente("Cliente Teste");
        primeiroPedido.setData(LocalDate.of(2022,02,20));
        primeiroPedido.setPreco(BigDecimal.valueOf(100.50));
        primeiroPedido.setProduto("Produto Teste");
        primeiroPedido.setQuantidade(1);
        return primeiroPedido;
    }
}
