package br.com.alura.comex.service.relatorios;

import br.com.alura.comex.model.entities.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class RelatorioProdutosMaisVendidosTest {

    @Test
    void listaNullRetornaIllegalArgumentException() {
        List<Pedido> pedidoVazio = null;
        RelatorioProdutosMaisCaros relatorio = new RelatorioProdutosMaisCaros(null);
        Assertions.assertThrows(IllegalArgumentException.class, relatorio::exibir);
    }

    @Test
    void listaVaziaRetornaIllegalArgumentException() {
        List<Pedido> pedidoVazio = Collections.emptyList();
        RelatorioProdutosMaisCaros relatorio = new RelatorioProdutosMaisCaros(pedidoVazio);
        Assertions.assertThrows(IllegalArgumentException.class, relatorio::exibir);
    }
}