package br.com.alura.comex;

import br.com.alura.comex.relatorios.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        String pedidosCSV = "pedidos.csv";
        ProcessadorDeCsv processadorDeCsv = new ProcessadorDeCsv();
        List<Pedido> listaPedidos = processadorDeCsv.listaPedidos(pedidosCSV);

        Relatorio relatorioSintetico = new RelatorioSintetico();
        relatorioSintetico.filtrarRelatorio(listaPedidos);
        relatorioSintetico.imprimirRelatorio();

        Relatorio relatorioClientesFieis = new RelatorioClientesFieis();
        relatorioClientesFieis.filtrarRelatorio(listaPedidos);
        relatorioClientesFieis.imprimirRelatorio();

        Relatorio relatorioVendasPorCategoria = new RelatorioVendasPorCategoria();
        relatorioVendasPorCategoria.filtrarRelatorio(listaPedidos);
        relatorioVendasPorCategoria.imprimirRelatorio();

        Relatorio relatorioProdutosMaisVendidos = new RelatorioProdutosMaisVendidos();
        relatorioProdutosMaisVendidos.filtrarRelatorio(listaPedidos);
        relatorioProdutosMaisVendidos.imprimirRelatorio();

        Relatorio relatorioProdutosMaisCaros = new RelatorioProdutosMaisCaros();
        relatorioProdutosMaisCaros.filtrarRelatorio(listaPedidos);
        relatorioProdutosMaisCaros.imprimirRelatorio();
    }
}
