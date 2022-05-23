package br.com.alura.comex.relatorios;

import br.com.alura.comex.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class RelatorioSintetico implements Relatorio {

    List<Pedido> listaDePedidos;

    int totalDeProdutosVendidos = 0;

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

    @Override
    public void filtrarRelatorio(List<Pedido> listaAtual) {
        listaDePedidos = listaAtual.stream()
                .collect(Collectors.toList());
    }

    @Override
    public void imprimirRelatorio() {

        System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
        System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", getTotalDePedidosRealizados(listaDePedidos));
        System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", getTotalDeProdutosVendidos(listaDePedidos));
        System.out.printf("- TOTAL DE CATEGORIAS: %s\n", getTotalDeCategorias(listaDePedidos));
        System.out.printf("- MONTANTE DE VENDAS: %s\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(getMontanteDeVendas(listaDePedidos).setScale(2, RoundingMode.HALF_DOWN)));
        System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(getPedidoMaisBarato(listaDePedidos).getValorTotal()), getPedidoMaisBarato(listaDePedidos).getProduto());
        System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(getPedidoMaisCaro(listaDePedidos).getValorTotal()), getPedidoMaisCaro(listaDePedidos).getProduto());

    }
}