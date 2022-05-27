package br.com.alura.comex.service.relatorios;

import br.com.alura.comex.model.entities.Pedido;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioProdutosMaisVendidos extends Relatorio {

    private Map<Integer, List<Pedido>> produtosVendidos;

    public RelatorioProdutosMaisVendidos(List<Pedido> listaDePedidos) {
        super(listaDePedidos);
    }

    @Override
    public void filtrarRelatorio() {
        produtosVendidos = getListaDePedidos().stream()
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
