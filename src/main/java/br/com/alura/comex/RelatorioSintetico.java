package br.com.alura.comex;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class RelatorioSintetico {

    int totalDeProdutosVendidos = 0;
    int totalDePedidosRealizados = 0;
    BigDecimal montanteDeVendas = BigDecimal.ZERO;
    Pedido pedidoMaisBarato;
    Pedido pedidoMaisCaro;
    int totalDeCategorias = 0;

    public RelatorioSintetico(List<Pedido> listaPedidos) {
        this.totalDeProdutosVendidos = getTotalDeProdutosVendidos(listaPedidos);
        this.totalDePedidosRealizados = getTotalDePedidosRealizados(listaPedidos);
        this.montanteDeVendas = getMontanteDeVendas(listaPedidos);
        this.pedidoMaisBarato = getPedidoMaisBarato(listaPedidos);
        this.pedidoMaisCaro = getPedidoMaisCaro(listaPedidos);
        this.totalDeCategorias = getTotalDeCategorias(listaPedidos);
    }

    public int getTotalDeProdutosVendidos(List<Pedido> listaPedidos) {
        return totalDeProdutosVendidos = listaPedidos.stream().mapToInt(Pedido::getQuantidade).sum();
    }

    public int getTotalDePedidosRealizados(List<Pedido> listaPedidos) {
        return listaPedidos.size();
    }

    public BigDecimal getMontanteDeVendas(List<Pedido> listaPedidos) {
        return listaPedidos.stream().map(Pedido::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Pedido getPedidoMaisBarato(List<Pedido> listaPedidos) {
        return listaPedidos.stream().min(Comparator.comparing(Pedido::getValorTotal)).orElseThrow(() -> new IllegalArgumentException("A lista de pedidos está vazia"));
    }

    public Pedido getPedidoMaisCaro(List<Pedido> listaPedidos) {
        return listaPedidos.stream().max(Comparator.comparing(Pedido::getValorTotal)).orElseThrow(() -> new IllegalArgumentException("A lista de pedidos está vazia"));
    }

    public int getTotalDeCategorias(List<Pedido> listaPedidos) {
        return (int) listaPedidos.stream().map(Pedido::getCategoria).distinct().count();
    }
}