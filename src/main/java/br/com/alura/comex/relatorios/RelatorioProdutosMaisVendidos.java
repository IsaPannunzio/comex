package br.com.alura.comex.relatorios;

import br.com.alura.comex.Pedido;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioProdutosMaisVendidos implements Relatorio {

    Map<Integer, List<Pedido>> produtosVendidos;

    @Override
    public void filtrarRelatorio(List<Pedido> listaDePedidos) {
        produtosVendidos = listaDePedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getQuantidade));
    }

    @Override
    public void imprimirRelatorio() {
        System.out.println("\n#### RELATÓRIO DE PRODUTOS MAIS VENDIDOS");

        produtosVendidos
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .filter(produto -> produto.getKey() > produtosVendidos.size()-3)
                .forEach(entry -> System.out.println(
                        "PRODUTO: " + entry.getValue().get(0).getProduto()
                                + "\nQUANTIDADE: " + entry.getKey()
                                + "\n"));
    }
}
