package br.com.alura.comex.service.relatorios;

import br.com.alura.comex.builder.PedidoBuilder;
import br.com.alura.comex.model.entities.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class RelatorioClientesFieisTest {

    @Test
    void listaNullRetornaIllegalArgumentException() {
        RelatorioClientesFieis relatorio = new RelatorioClientesFieis(null);
        Assertions.assertThrows(IllegalArgumentException.class, relatorio::exibir);
    }

    @Test
    void listaVaziaRetornaIllegalArgumentException() {
        List<Pedido> pedidoVazio = Collections.emptyList();
        RelatorioClientesFieis relatorio = new RelatorioClientesFieis(pedidoVazio);
        Assertions.assertThrows(IllegalArgumentException.class, relatorio::exibir);
    }

    @Test
    void relatorioListaComUmUnicoPedido() {
        Pedido pedidoUnico = PedidoBuilder.getPedidoUnico();
        RelatorioClientesFieis relatorio = new RelatorioClientesFieis(Collections.singletonList(pedidoUnico));
        String nomeCliente = "Cliente Teste";
        Long expected = 1L;
        Assertions.assertEquals(expected, relatorio.quantosClientes(nomeCliente));
    }

    @Test
    void relatorioListadeTresPedidosDoMesmoCliente() {
        List<Pedido> listaPedidos = PedidoBuilder.getListaDePedidos();
        RelatorioClientesFieis relatorio = new RelatorioClientesFieis(listaPedidos);
        String nomeCliente = "Cliente um";
        Long expected = 3L;
        Assertions.assertEquals(expected, relatorio.quantosClientes(nomeCliente));
    }
}

