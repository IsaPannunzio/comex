package br.com.alura.comex.service.relatorios;

import br.com.alura.comex.model.entities.Pedido;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public abstract class Relatorio {

    private final List<Pedido> listaDePedidos;

    public Relatorio(List<Pedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }

    public int getTotalDeProdutosVendidos() {
        return listaDePedidos.stream().mapToInt(Pedido::getQuantidade).sum();
    }

    public int getTotalDePedidosRealizados() {
        return listaDePedidos.size();
    }

    public BigDecimal getMontanteDeVendas() {
        return listaDePedidos.stream().map(Pedido::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Pedido getPedidoMaisBarato() {
        return listaDePedidos.stream().min(Comparator.comparing(Pedido::getValorTotal)).orElseThrow(() -> new IllegalArgumentException("A lista de pedidos está vazia"));
    }

    public Pedido getPedidoMaisCaro() {
        return listaDePedidos.stream().max(Comparator.comparing(Pedido::getValorTotal)).orElseThrow(() -> new IllegalArgumentException("A lista de pedidos está vazia"));
    }

    public int getTotalDeCategorias() {
        return (int) listaDePedidos.stream().map(Pedido::getCategoria).distinct().count();
    }

    public List<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public abstract void filtrarRelatorio();

    public abstract void imprimirRelatorio();

    public void exibir() {
        if (listaDePedidos == null || listaDePedidos.isEmpty()) {
            throw new IllegalArgumentException("A lista de pedidos está vazia");
        }
        filtrarRelatorio();
        imprimirRelatorio();
    }
}
