package br.com.alura.comex.relatorios;

import br.com.alura.comex.Pedido;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RelatorioProdutosMaisCaros implements Relatorio {

    Map<String, Pedido> produtosMaisCaros;

    @Override
    public void filtrarRelatorio(List<Pedido> listaDePedidos) {
        produtosMaisCaros = listaDePedidos.stream().collect(Collectors.toMap(Pedido::getCategoria, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparing(Pedido::getPreco))));

    }

    @Override
    public void imprimirRelatorio() {
        System.out.println("\n#### RELATÓRIO DE PRODUTO MAIS CARO POR CATEGORIA");
        produtosMaisCaros.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(
                        entry -> System.out.println("CATEGORIA: " + entry.getKey() + "\nPRODUTO: "
                                + entry.getValue().getProduto() + "\nPREÇO: " + NumberFormat
                                .getCurrencyInstance(new Locale("pt", "BR")).format(entry.getValue().getPreco())
                                + "\n"));
    }
}
