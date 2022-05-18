package br.com.alura.comex;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        String pedidosCSV = "pedidos.csv";
        ProcessadorDeCsv processadorDeCsv = new ProcessadorDeCsv();
        List<Pedido> listaPedidos = processadorDeCsv.listaPedidos(pedidosCSV);
        RelatorioSintetico relatorioSintetico = new RelatorioSintetico(listaPedidos);



        System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
        System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", relatorioSintetico.getTotalDePedidosRealizados(listaPedidos));
        System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", relatorioSintetico.getTotalDeProdutosVendidos(listaPedidos));
        System.out.printf("- TOTAL DE CATEGORIAS: %s\n", relatorioSintetico.getTotalDeCategorias(listaPedidos));
        System.out.printf("- MONTANTE DE VENDAS: %s\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(relatorioSintetico.getMontanteDeVendas(listaPedidos).setScale(2, RoundingMode.HALF_DOWN)));
        System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(relatorioSintetico.getPedidoMaisBarato(listaPedidos).getPreco().multiply(new BigDecimal(relatorioSintetico.getPedidoMaisBarato(listaPedidos).getQuantidade())).setScale(2, RoundingMode.HALF_DOWN)), relatorioSintetico.getPedidoMaisBarato(listaPedidos).getProduto());
        System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(relatorioSintetico.getPedidoMaisCaro(listaPedidos).getPreco().multiply(new BigDecimal(relatorioSintetico.getPedidoMaisCaro(listaPedidos).getQuantidade())).setScale(2, RoundingMode.HALF_DOWN)), relatorioSintetico.getPedidoMaisCaro(listaPedidos).getProduto());
      }
}
