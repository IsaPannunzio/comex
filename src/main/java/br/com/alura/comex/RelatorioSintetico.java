package br.com.alura.comex;

import java.math.BigDecimal;
import java.util.List;

public class RelatorioSintetico {

    int totalDeProdutosVendidos = 0;
    int totalDePedidosRealizados = 0;
    BigDecimal montanteDeVendas = BigDecimal.ZERO;
    Pedido pedidoMaisBarato;
    Pedido pedidoMaisCaro;

    CategoriasProcessadas categoriasProcessadas = new CategoriasProcessadas();
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
        return totalDeProdutosVendidos = listaPedidos.stream().mapToInt(pedido -> pedido.getQuantidade()).sum();
    }

    public int getTotalDePedidosRealizados(List<Pedido> listaPedidos) {
        return listaPedidos.size();
    }

    public BigDecimal getMontanteDeVendas(List<Pedido> listaPedidos) {
        return listaPedidos.stream().map(pedido -> pedido.getValorTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Pedido getPedidoMaisBarato(List<Pedido> listaPedidos) {
        return pedidoMaisBarato;
    }

    public Pedido getPedidoMaisCaro(List<Pedido> listaPedidos) {
        return pedidoMaisCaro;
    }

    public CategoriasProcessadas getCategoriasProcessadas() {
        return categoriasProcessadas;
    }

    public int getTotalDeCategorias(List<Pedido> listaPedidos) {
        listaPedidos.forEach(pedido -> categoriasProcessadas.add(pedido.getCategoria()));
        return categoriasProcessadas.size();
    }
}
