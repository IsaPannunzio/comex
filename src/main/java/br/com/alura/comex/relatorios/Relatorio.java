package br.com.alura.comex.relatorios;

import br.com.alura.comex.Pedido;

import java.util.List;

public interface Relatorio {

    void filtrarRelatorio(List<Pedido> listaDePedidos);

    void imprimirRelatorio();
}
