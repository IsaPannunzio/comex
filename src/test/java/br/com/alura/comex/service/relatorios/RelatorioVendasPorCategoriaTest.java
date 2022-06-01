package br.com.alura.comex.service.relatorios;

import br.com.alura.comex.builder.PedidoBuilder;
import br.com.alura.comex.model.entities.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;


class RelatorioVendasPorCategoriaTest {

    @Test
    void listaNullRetornaIllegalArgumentException() {
        RelatorioVendasPorCategoria relatorio = new RelatorioVendasPorCategoria(null);
        Assertions.assertThrows(IllegalArgumentException.class, relatorio::exibir);
    }

    @Test
    void listaVaziaRetornaIllegalArgumentException() {
        List<Pedido> pedidoVazio = Collections.emptyList();
        RelatorioVendasPorCategoria relatorio = new RelatorioVendasPorCategoria(pedidoVazio);
        Assertions.assertThrows(IllegalArgumentException.class, relatorio::exibir);
    }

    @Test
    void relatorioListaComUmUnicoPedido() {
        Pedido pedidoUnico = PedidoBuilder.getPedidoUnico();
        RelatorioVendasPorCategoria relatorio = new RelatorioVendasPorCategoria(Collections.singletonList(pedidoUnico));
        String nomeCliente = "Cliente Teste";
        Long expected = 1L;
        Assertions.assertEquals(expected, relatorio.quantosClientes(nomeCliente));
    }

    @Test
    void relatorioListadeTresPedidosDoMesmoCliente() {
        List<Pedido> listaPedidos = PedidoBuilder.getListaDePedidos();
        RelatorioVendasPorCategoria relatorio = new RelatorioVendasPorCategoria(listaPedidos);
        String nomeCliente = "Cliente um";
        Long expected = 3L;
        Assertions.assertEquals(expected, relatorio.quantosClientes(nomeCliente));
    }
}