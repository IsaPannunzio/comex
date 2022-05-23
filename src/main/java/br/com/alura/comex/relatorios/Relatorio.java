package br.com.alura.comex.relatorios;

import br.com.alura.comex.Pedido;

import java.util.List;

public interface Relatorio {

    public static final List<Pedido> listaDePedidos = null;

    public void filtrarRelatorio(List<Pedido> listaDePedidos);

    public void imprimirRelatorio();
}
