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
        List<Pedido> pedidoNulo = null;
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
        Pedido pedidoUnico = PedidoBuilder.getPrimeiroPedido();
        RelatorioVendasPorCategoria relatorio = new RelatorioVendasPorCategoria(Collections.singletonList(pedidoUnico));
        Assertions.assertAll(relatorio::exibir);
    }
}