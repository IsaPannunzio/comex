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
        List<Pedido> pedidoNulo = null;
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
        Pedido pedidoUnico = PedidoBuilder.getPrimeiroPedido();
        RelatorioClientesFieis relatorio = new RelatorioClientesFieis(Collections.singletonList(pedidoUnico));
        Assertions.assertAll(relatorio::exibir);
    }
}