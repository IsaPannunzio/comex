package br.com.alura.comex.service.relatorios;

import br.com.alura.comex.builder.PedidoBuilder;
import br.com.alura.comex.model.entities.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class RelatorioProdutosMaisCarosTest {

    @Test
    void listaNullRetornaIllegalArgumentException() {
        RelatorioProdutosMaisCaros relatorio = new RelatorioProdutosMaisCaros(null);
        Assertions.assertThrows(IllegalArgumentException.class, relatorio::exibir);
    }

    @Test
    void listaVaziaRetornaIllegalArgumentException() {
        List<Pedido> pedidoVazio = Collections.emptyList();
        RelatorioProdutosMaisCaros relatorio = new RelatorioProdutosMaisCaros(pedidoVazio);
        Assertions.assertThrows(IllegalArgumentException.class, relatorio::exibir);
    }

    @Test
    void relatorioListaComUmUnicoPedido() {
        Pedido pedidoUnico = PedidoBuilder.getPedidoUnico();
        RelatorioProdutosMaisCaros relatorio = new RelatorioProdutosMaisCaros(Collections.singletonList(pedidoUnico));
        String nomeCliente = "Cliente Teste";
        Long expected = 1L;
        Assertions.assertEquals(expected, relatorio.quantosClientes(nomeCliente));
    }

    @Test
    void relatorioListadeTresPedidosDoMesmoCliente() {
        List<Pedido> listaPedidos = PedidoBuilder.getListaDePedidos();
        RelatorioProdutosMaisCaros relatorio = new RelatorioProdutosMaisCaros(listaPedidos);
        String nomeCliente = "Cliente um";
        Long expected = 3L;
        Assertions.assertEquals(expected, relatorio.quantosClientes(nomeCliente));
    }
}